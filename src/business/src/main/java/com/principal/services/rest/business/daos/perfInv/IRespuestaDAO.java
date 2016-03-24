package com.principal.services.rest.business.daos.perfInv;

import com.principal.services.rest.common.dto.perfil.inversionista.PreguntaDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
public interface IRespuestaDAO {

  List<Long> getHistoricoRespuesta(@Param("rut") String rut);

  List<PreguntaDTO> getRespuestasByPregunta(@Param("preguntaId") Long preguntaId,@Param("rut") String rut);

  Long getPuntajeFinal(@Param("respuestas") List<Long> respuestas);

  Long getPerfilId(@Param("puntaje") Long puntaje);

  Long saveHistoricoFormulario(Map<String, Object> map);

  void saveHistoricoRespuesta(@Param("formularioHistoricoId") Integer formularioHistoricoId,
                              @Param("respuestaId") Long respuestaId);
}
