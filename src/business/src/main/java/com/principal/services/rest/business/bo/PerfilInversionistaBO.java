package com.principal.services.rest.business.bo;

import com.principal.services.rest.business.daos.perfInv.IClienteDAO;
import com.principal.services.rest.business.daos.perfInv.IPerfilBduDAO;
import com.principal.services.rest.business.daos.perfInv.IPreguntaDAO;
import com.principal.services.rest.business.daos.perfInv.IRespuestaDAO;
import com.principal.services.rest.common.dto.perfil.inversionista.ClienteDTO;
import com.principal.services.rest.common.dto.perfil.inversionista.PerfilDTO;
import com.principal.services.rest.common.dto.perfil.inversionista.PreguntaDTO;
import com.principal.services.rest.common.exceptions.ClienteNoExisteException;
import com.principal.services.rest.common.exceptions.ClienteSinPerfilException;
import com.principal.services.rest.common.exceptions.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
@Component
public class PerfilInversionistaBO {

  private static final Logger log = LoggerFactory.getLogger(PerfilInversionistaBO.class);

  @Autowired
  private IPreguntaDAO preguntaDAO;

  @Autowired
  private IRespuestaDAO respuestaDAO;

  @Autowired
  private IPerfilBduDAO perfilBduDAO;

  @Autowired
  private IClienteDAO clienteDAO;

  public List<PreguntaDTO> getPreguntas(String rut, String rutDv) throws ClienteNoExisteException, ServiceException {

    if (!perfilBduDAO.clientExists(rut)) {
      throw new ClienteNoExisteException();
    }

    try {
      List<PreguntaDTO> preguntas = preguntaDAO.getPreguntas(rut);


      return preguntas;
    } catch (Exception e) {
      log.error("Ha ocurrido un error al obtener las preguntas", e);
      throw new ServiceException(e);
    }
  }

  public Map<String, Long> getPerfil(String rut, String rutDv, List<Long> respuestas)
    throws ClienteNoExisteException, ServiceException {

    if (!perfilBduDAO.clientExists(rut)) {
      throw new ClienteNoExisteException();
    }

    try {
      Long puntajeFinal = respuestaDAO.getPuntajeFinal(respuestas);
      Long perfilId = respuestaDAO.getPerfilId(puntajeFinal);

      Map<String, Object> map = new HashMap<String, Object>();
      map.put("formularioHistoricoId", 0);
      map.put("rut", rut);
      map.put("perfilId", perfilId);
      respuestaDAO.saveHistoricoFormulario(map);

      for (Long respuestaId : respuestas) {
        respuestaDAO.saveHistoricoRespuesta((Integer) map.get("formularioHistoricoId"), respuestaId);
      }

      Map<String, Long> response = new HashMap<String, Long>();
      response.put("id", perfilId);
      response.put("puntajeFinal", puntajeFinal);

      return response;
    } catch (Exception e) {
      log.error("Ha ocurrido un error al calcular y guardar el perfil", e);
      throw new ServiceException(e);
    }
  }

  public PerfilDTO updatePerfilIdByRut(String rut, String rutDv, Long perfilId)
    throws ClienteNoExisteException, ServiceException {

    if (!perfilBduDAO.clientExists(rut)) {
      throw new ClienteNoExisteException();
    }

    try {
      perfilBduDAO.updatePerfilIdByRut(perfilId, rut);

      PerfilDTO perfil = new PerfilDTO();
      perfil.setClasificacion(perfilBduDAO.getPerfilById(perfilId));
      return perfil;
    } catch (Exception e) {
      log.error("Ha ocurrido un error al actualizar en bdu el perfil", e);
      throw new ServiceException(e);
    }
  }


  public PerfilDTO getPerfil(String rut, String rutDv)
    throws ClienteNoExisteException, ClienteSinPerfilException, ServiceException {

    if (!perfilBduDAO.clientExists(rut)) {
      throw new ClienteNoExisteException();
    }
    PerfilDTO perfil;

    perfil = new PerfilDTO();
    perfil.setClasificacion(perfilBduDAO.getPerfilByRut(rut));

    if (perfil.getClasificacion() == null) {
      throw new ClienteSinPerfilException();
    }

    try {
      List<Long> respuestas = respuestaDAO.getHistoricoRespuesta(rut);

      Long puntajeFinal = 0L;
      if (respuestas != null && respuestas.size() > 0) {
        puntajeFinal = respuestaDAO.getPuntajeFinal(respuestas);
      }
      perfil.setPuntaje(puntajeFinal);

    } catch (Exception e) {
      log.error("Ha ocurrido un error al obtener el perfil", e);
      throw new ServiceException(e);
    }


    return perfil;
  }

  public List<ClienteDTO> getCliente(String rut, String rutDv)
    throws ClienteNoExisteException, ServiceException{

    if (!perfilBduDAO.clientExists(rut)) {
      throw new ClienteNoExisteException();
    }

    try{

      List<ClienteDTO> cliente = clienteDAO.getClienteByRut(rut);
      return cliente;

    }catch (Exception e) {
      log.error("Ha ocurrido un error al obtener al Cliente", e);
      throw new ServiceException(e);
    }
  }

}
