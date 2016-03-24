package com.principal.services.rest.controllers.rest;

import com.principal.services.rest.common.dto.timbre.DocumentoDTO;
import com.principal.services.rest.common.ejb.local.TimbreLocal;
import com.principal.services.rest.common.exceptions.CodigoNotFoundException;
import com.principal.services.rest.common.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: principal-rest
 */

@RestController
@RequestMapping(value = "/timbre",
  produces = "application/vnd.principal-v1.0+json",
  consumes = "application/vnd.principal-v1.0+json")
public class TimbreController {

  @Autowired
  private TimbreLocal timbreLocal;

  @RequestMapping(value = "/timbrar", method = RequestMethod.POST)
  public Map<String, Object> timbrar(@RequestBody DocumentoDTO documento) throws CodigoNotFoundException, ServiceException {
    DocumentoDTO doc = timbreLocal.timbrar(documento);

    Map<String, Object> resultado = new HashMap<String, Object>();

    resultado.put("documento", doc);
    resultado.put("mensaje", "OK");

    return resultado;
  }

}
