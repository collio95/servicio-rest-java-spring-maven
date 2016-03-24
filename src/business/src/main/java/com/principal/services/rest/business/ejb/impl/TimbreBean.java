package com.principal.services.rest.business.ejb.impl;

import com.principal.services.rest.business.bo.TimbreBO;
import com.principal.services.rest.common.dto.timbre.DocumentoDTO;
import com.principal.services.rest.common.dto.timbre.ImagenDTO;
import com.principal.services.rest.common.dto.timbre.TimbreDTO;
import com.principal.services.rest.common.dto.timbre.TipoDocumentoDTO;
import com.principal.services.rest.common.ejb.local.TimbreLocal;
import com.principal.services.rest.common.exceptions.CodigoNotFoundException;
import com.principal.services.rest.common.exceptions.ServiceException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDPixelMap;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.util.Base64Utils;

import javax.ejb.Stateless;
import javax.imageio.ImageIO;
import javax.interceptor.Interceptors;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
@Stateless(mappedName = "TimbreBean")
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class TimbreBean implements TimbreLocal {

  private static final Logger log = LoggerFactory.getLogger(TimbreBean.class);

  @Autowired
  private TimbreBO timbreBO;

  @Override
  public DocumentoDTO timbrar(DocumentoDTO documento) throws CodigoNotFoundException, ServiceException {

    TimbreDTO timbre = getTimbre(documento.getCodigo());
    if (timbre == null) {
      throw new CodigoNotFoundException();
    }

    try {

      byte[] bytes = Base64Utils.decodeFromString(documento.getBase64());
      byte[] bytesImage = Base64Utils.decodeFromString(timbre.getImagen().getBase64());
      PDDocument doc = PDDocument.load(new ByteArrayInputStream(bytes));
      for (Integer pagina : documento.getPaginas()) {
        PDPage page = (PDPage) doc.getDocumentCatalog().getAllPages().get(pagina);
        BufferedImage awtImage = ImageIO.read(new ByteArrayInputStream(bytesImage));
        PDXObject image = new PDPixelMap(doc, awtImage);
        PDPageContentStream content = new PDPageContentStream(doc, page, true, true);
        content.drawXObject(image, timbre.getX(), timbre.getY(), timbre.getImagen().getAncho(), timbre.getImagen().getAlto());
        content.close();
      }

      ByteArrayOutputStream out = new ByteArrayOutputStream();
      doc.save(out);
      doc.close();

      documento.setBase64(Base64Utils.encodeToString(out.toByteArray()));

    } catch (IndexOutOfBoundsException e) {
      log.error("Pagina no encontrada", e);
      throw new ServiceException("Pagina no encontrada");
    } catch (Exception e) {
      log.error("Error al timbrar el documento", e);
      throw new ServiceException(e);
    }

    return documento;
  }

  @Override
  public TimbreDTO getTimbre(String codigoDocumento) {
    return timbreBO.getTimbre(codigoDocumento);
  }

  @Override
  public List<ImagenDTO> getImagenes() {
    return timbreBO.getImagenes();
  }

  @Override
  public List<TipoDocumentoDTO> getTiposDocumentos() {
    return timbreBO.getTiposDocumentos();
  }

  @Override
  public List<TimbreDTO> getTimbres() {
    return timbreBO.getTimbres();
  }

  @Override
  public void saveImagen(ImagenDTO imagen) {
    timbreBO.saveImagen(imagen);
  }

  @Override
  public Long saveTipoDocumento(TipoDocumentoDTO tipoDocumento) {
    return timbreBO.saveTipoDocumento(tipoDocumento);
  }

  @Override
  public void saveTimbre(TimbreDTO timbre) {
    timbreBO.saveTimbre(timbre);
  }

  @Override
  public void deleteImagen(Long id) {
    timbreBO.deleteImagen(id);
  }

  @Override
  public void deleteTipoDocumento(Long id) {
    timbreBO.deleteTipoDocumento(id);
  }

  @Override
  public void deleteTimbre(Long id) {
    timbreBO.deleteTimbre(id);
  }
}
