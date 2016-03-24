package com.principal.services.rest.business.daos.timbre;

import com.principal.services.rest.common.dto.timbre.TimbreDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
public interface ITimbreDAO {

  TimbreDTO getTimbreByCodigo(String codigoDocumento);

  List<TimbreDTO> getTimbres();

  TimbreDTO getTimbre(@Param("id") Long id);

  void saveTimbre(TimbreDTO timbre);

  void updateTimbre(TimbreDTO timbre);

  void deleteTimbre(@Param("id") Long id);
}
