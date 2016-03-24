package com.principal.services.rest.business.bo;

import com.principal.services.rest.business.daos.timbre.IImagenDAO;
import com.principal.services.rest.business.daos.timbre.ITimbreDAO;
import com.principal.services.rest.business.daos.timbre.ITipoDocumentoDAO;
import com.principal.services.rest.common.dto.timbre.ImagenDTO;
import com.principal.services.rest.common.dto.timbre.TimbreDTO;
import com.principal.services.rest.common.dto.timbre.TipoDocumentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
@Component
public class TimbreBO {

  @Autowired
  private ITimbreDAO timbreDAO;

  @Autowired
  private ITipoDocumentoDAO tipoDocumentoDAO;

  @Autowired
  private IImagenDAO imagenDAO;


  public TimbreDTO getTimbre(String codigoDocumento) {
    return timbreDAO.getTimbreByCodigo(codigoDocumento);
  }

  public List<ImagenDTO> getImagenes() {
    return imagenDAO.getImagenes();
  }

  public List<TipoDocumentoDTO> getTiposDocumentos() {
    return tipoDocumentoDAO.getTipoDocumentos();
  }

  public List<TimbreDTO> getTimbres() {
    return timbreDAO.getTimbres();
  }

  public void saveImagen(ImagenDTO imagen) {
    if (imagen.getId() == null) {
      imagenDAO.saveImagen(imagen);
    } else {
      imagenDAO.updateImagen(imagen);
    }
  }

  public Long saveTipoDocumento(TipoDocumentoDTO tipoDocumento) {
    if (tipoDocumento.getId() == null) {
      tipoDocumentoDAO.saveTipoDocumento(tipoDocumento);
    } else {
      tipoDocumentoDAO.updateTipoDocumento(tipoDocumento);
    }
    return tipoDocumento.getId();
  }

  public void saveTimbre(TimbreDTO timbre) {
    if (timbre.getId() == null) {
      timbreDAO.saveTimbre(timbre);
    } else {
      timbreDAO.updateTimbre(timbre);
    }
  }

  public void deleteImagen(Long id) {
    imagenDAO.deleteImagen(id);
  }

  public void deleteTipoDocumento(Long id) {
    tipoDocumentoDAO.deleteTipoDocumento(id);
  }

  public void deleteTimbre(Long id) {
    timbreDAO.deleteTimbre(id);
  }
}
