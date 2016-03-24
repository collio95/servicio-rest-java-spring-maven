package com.principal.services.rest.common.ejb.local;

import com.principal.services.rest.common.dto.timbre.DocumentoDTO;
import com.principal.services.rest.common.dto.timbre.ImagenDTO;
import com.principal.services.rest.common.dto.timbre.TimbreDTO;
import com.principal.services.rest.common.dto.timbre.TipoDocumentoDTO;
import com.principal.services.rest.common.exceptions.CodigoNotFoundException;
import com.principal.services.rest.common.exceptions.ServiceException;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
@Local
public interface TimbreLocal {

  DocumentoDTO timbrar(DocumentoDTO documento) throws CodigoNotFoundException, ServiceException;

  TimbreDTO getTimbre(String codigoDocumento);

  List<ImagenDTO> getImagenes();

  List<TipoDocumentoDTO> getTiposDocumentos();

  List<TimbreDTO> getTimbres();

  void saveImagen(ImagenDTO imagen);

  Long saveTipoDocumento(TipoDocumentoDTO tipoDocumento);

  void saveTimbre(TimbreDTO timbre);

  void deleteImagen(Long id);

  void deleteTipoDocumento(Long id);

  void deleteTimbre(Long id);
}
