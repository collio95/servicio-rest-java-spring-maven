package com.principal.services.rest.business.daos.timbre;

import com.principal.services.rest.common.dto.timbre.TipoDocumentoDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
public interface ITipoDocumentoDAO {

  List<TipoDocumentoDTO> getTipoDocumentos();

  TipoDocumentoDTO getTipoDocumento(@Param("id") Long id);

  void saveTipoDocumento(TipoDocumentoDTO tipoDocumento);

  void updateTipoDocumento(TipoDocumentoDTO tipoDocumento);

  void deleteTipoDocumento(@Param("id") Long id);
}
