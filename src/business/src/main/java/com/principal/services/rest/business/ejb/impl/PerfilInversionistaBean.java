package com.principal.services.rest.business.ejb.impl;


import com.principal.services.rest.business.bo.PerfilInversionistaBO;
import com.principal.services.rest.common.dto.perfil.inversionista.ClienteDTO;
import com.principal.services.rest.common.dto.perfil.inversionista.PerfilDTO;
import com.principal.services.rest.common.dto.perfil.inversionista.PreguntaDTO;
import com.principal.services.rest.common.ejb.local.PerfilInversionistaLocal;
import com.principal.services.rest.common.exceptions.ClienteNoExisteException;
import com.principal.services.rest.common.exceptions.ClienteSinPerfilException;
import com.principal.services.rest.common.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
@Stateless(mappedName = "PerfilInversionistaBean")
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class PerfilInversionistaBean implements PerfilInversionistaLocal {

  @Autowired
  private PerfilInversionistaBO perfilInversionistaBO;

  @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
  @Override
  public List<PreguntaDTO> getPreguntas(String rut, String rutDv)
    throws ClienteNoExisteException, ServiceException {
    return perfilInversionistaBO.getPreguntas(rut, rutDv);
  }

  @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
  @Override
  public Map<String,Long> getPerfil(String rut, String rutDv, List<Long> respuestas)
    throws ClienteNoExisteException, ServiceException {
    return perfilInversionistaBO.getPerfil(rut, rutDv, respuestas);
  }

  @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
  @Override
  public PerfilDTO updatePerfilIdByRut(String rut, String rutDv, Long perfilId)
    throws ClienteNoExisteException, ServiceException {
    return perfilInversionistaBO.updatePerfilIdByRut(rut, rutDv, perfilId);
  }

  @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
  @Override
  public PerfilDTO getPerfil(String rut, String rutDv)
    throws ClienteNoExisteException, ClienteSinPerfilException, ServiceException {
    return perfilInversionistaBO.getPerfil(rut, rutDv);
  }

  @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
  @Override
  public List<ClienteDTO> getCliente(String rut, String rutDv)
    throws ClienteNoExisteException, ServiceException {
    return perfilInversionistaBO.getCliente(rut,rutDv);
  }

}
