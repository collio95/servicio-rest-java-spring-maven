package com.principal.services.rest.controllers.rest;

import com.principal.services.rest.common.dto.perfil.inversionista.ClienteDTO;
import com.principal.services.rest.common.dto.perfil.inversionista.PerfilDTO;
import com.principal.services.rest.common.dto.perfil.inversionista.PreguntaDTO;
import com.principal.services.rest.common.dto.response.PerfilResponseDTO;
import com.principal.services.rest.common.ejb.local.PerfilInversionistaLocal;
import com.principal.services.rest.common.exceptions.ClienteNoExisteException;
import com.principal.services.rest.common.exceptions.ClienteSinPerfilException;
import com.principal.services.rest.common.exceptions.FormatoRutException;
import com.principal.services.rest.common.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA. User: Sergio Puas (sjpuas) - Bennu Ltda. Project:
 * principal-rest
 */
@RestController
@RequestMapping(value = "/perfilInversionista",
        produces = "application/vnd.principal-v1.0+json",
        consumes = "application/vnd.principal-v1.0+json")
public class PerfilInversionistaController {

    @Autowired
    private PerfilInversionistaLocal perfilInversionistaLocal;

    private Boolean isValidFormatRut(String rut) {
        return Pattern.compile("\\d{1,8}[-][0-9kK]{1}").matcher(rut).matches();
    }

    @RequestMapping(value = "/{rut}", method = RequestMethod.GET)
    public PerfilResponseDTO perfil(@PathVariable String rut)
            throws ClienteNoExisteException, ClienteSinPerfilException, FormatoRutException, ServiceException {

        if (!isValidFormatRut(rut)) {
            throw new FormatoRutException();
        }

        String[] rutArray = rut.split("-");
        PerfilDTO perfil = perfilInversionistaLocal.getPerfil(rutArray[0], rutArray[1]);

        PerfilResponseDTO resultado = new PerfilResponseDTO();

        resultado.setMensaje("OK");
        resultado.setPerfil(perfil);

        return resultado;
    }

    @RequestMapping(value = "/{rut}/preguntas", method = RequestMethod.GET)
    public Map<String, Object> preguntas(@PathVariable String rut)
            throws ClienteNoExisteException, FormatoRutException, ServiceException {

        if (!isValidFormatRut(rut)) {
            throw new FormatoRutException();
        }

        String[] rutArray = rut.split("-");
        List<PreguntaDTO> preguntas = perfilInversionistaLocal.getPreguntas(rutArray[0], rutArray[1]);

        Map<String, Object> resultado = new HashMap<String, Object>();

        resultado.put("preguntas", preguntas);
        resultado.put("mensaje", "OK");

        return resultado;
    }

    @RequestMapping(value = "/{rut}/preguntas", method = RequestMethod.POST)
    public PerfilResponseDTO respuestas(@PathVariable String rut,
            @RequestBody List<Long> respuestas)
            throws ClienteNoExisteException, FormatoRutException, ServiceException {

        if (!isValidFormatRut(rut)) {
            throw new FormatoRutException();
        }

        String[] rutArray = rut.split("-");
        Map<String, Long> perfilMap = perfilInversionistaLocal.getPerfil(rutArray[0], rutArray[1], respuestas);
        PerfilDTO perfil = perfilInversionistaLocal.updatePerfilIdByRut(rutArray[0], rutArray[1], perfilMap.get("id"));

        perfil.setPuntaje(perfilMap.get("puntajeFinal"));

        PerfilResponseDTO resultado = new PerfilResponseDTO();

        resultado.setMensaje("OK");
        resultado.setPerfil(perfil);

        return resultado;
    }

    @RequestMapping(value = "/{rut}/consultarCliente", method = RequestMethod.GET)
    public List<ClienteDTO> consultarCliente(@PathVariable String rut)
      throws ClienteNoExisteException,FormatoRutException, ServiceException {

      if(!isValidFormatRut(rut)){
        throw new FormatoRutException();
      }

      String[] rutArray = rut.split("-");
      List<ClienteDTO> cliente = perfilInversionistaLocal.getCliente(rutArray[0], rutArray[1]);

      return cliente;
    }

}
