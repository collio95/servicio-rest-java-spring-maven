package com.principal.services.rest.business.daos.perfInv;

import com.principal.services.rest.common.dto.perfil.inversionista.PreguntaDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
public interface IPreguntaDAO {

  List<PreguntaDTO> getPreguntas(@Param("rut")String rut);

}
