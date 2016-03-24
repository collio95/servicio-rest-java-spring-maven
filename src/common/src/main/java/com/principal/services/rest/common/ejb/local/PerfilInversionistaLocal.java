package com.principal.services.rest.common.ejb.local;

import com.principal.services.rest.common.dto.perfil.inversionista.ClienteDTO;
import com.principal.services.rest.common.dto.perfil.inversionista.PerfilDTO;
import com.principal.services.rest.common.dto.perfil.inversionista.PreguntaDTO;
import com.principal.services.rest.common.exceptions.ClienteNoExisteException;
import com.principal.services.rest.common.exceptions.ClienteSinPerfilException;
import com.principal.services.rest.common.exceptions.ServiceException;

import javax.ejb.Local;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
@Local
public interface PerfilInversionistaLocal {

  List<PreguntaDTO> getPreguntas(String rut, String rutDv) throws ClienteNoExisteException, ServiceException;

  Map<String,Long> getPerfil(String rut, String rutDv, List<Long> respuestas) throws ClienteNoExisteException,ServiceException;

  PerfilDTO updatePerfilIdByRut(String rut, String rutDv, Long perfilId) throws ClienteNoExisteException,ServiceException;

  PerfilDTO getPerfil(String rut, String rutDv) throws ClienteNoExisteException, ClienteSinPerfilException, ServiceException;

  List<ClienteDTO> getCliente(String rut, String rutDv) throws ClienteNoExisteException, ServiceException;

}
