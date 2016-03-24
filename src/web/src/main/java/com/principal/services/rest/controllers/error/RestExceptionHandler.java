package com.principal.services.rest.controllers.error;

import com.principal.services.rest.common.dto.ErrorDTO;
import com.principal.services.rest.common.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
@ControllerAdvice
public class RestExceptionHandler {

  /**
   * Errores generales
   **/

  @RequestMapping(produces = {"application/vnd.principal-v1.0+json"})
  @ExceptionHandler({MissingServletRequestParameterException.class,
    UnsatisfiedServletRequestParameterException.class,
    ServletRequestBindingException.class
  })
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public
  @ResponseBody
  ErrorDTO handleRequestException(Exception ex) {
    return new ErrorDTO("Error al realizar la petición", "400");
  }

  @RequestMapping(produces = {"application/vnd.principal-v1.0+json"})
  @ExceptionHandler({SinAccesoException.class})
  @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
  public
  @ResponseBody
  ErrorDTO handleUnauthorized(Exception ex) {
    return new ErrorDTO("No Autorizado", "401");
  }

  @RequestMapping(produces = {"application/vnd.principal-v1.0+json"})
  @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
  @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
  public
  @ResponseBody
  ErrorDTO handleMethodNotSupported(Exception ex) {
    return new ErrorDTO("Metodo no soportado", "405");
  }

  @RequestMapping(produces = {"application/vnd.principal-v1.0+json"})
  @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
  @ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
  public
  @ResponseBody
  ErrorDTO handleUnsupportedMediaTypeException(HttpMediaTypeNotSupportedException ex) throws IOException {
    return new ErrorDTO("Content-type no soportado", "415");
  }

  @RequestMapping(produces = {"application/vnd.principal-v1.0+json"})
  @ExceptionHandler({ServiceException.class, Exception.class})
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public
  @ResponseBody
  ErrorDTO handleUncaughtException(Exception ex) throws IOException {
    return new ErrorDTO("Ha ocurrido un error interno al realizar la petición", "500");
  }

  /**
   * Errores de perfil inversionista
   **/

  @RequestMapping(produces = {"application/vnd.principal-v1.0+json"})
  @ExceptionHandler({ClienteNoExisteException.class})
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public
  @ResponseBody
  ErrorDTO handleClienteNoExiste(Exception ex) {
    return new ErrorDTO("Cliente no existe", "404");
  }

  @RequestMapping(produces = {"application/vnd.principal-v1.0+json"})
  @ExceptionHandler({ClienteSinPerfilException.class})
  @ResponseStatus(value = HttpStatus.FORBIDDEN)
  public
  @ResponseBody
  ErrorDTO handleClienteSinPerfil(Exception ex) {
    return new ErrorDTO("Cliente sin perfil creado", "403");
  }


  @RequestMapping(produces = {"application/vnd.principal-v1.0+json"})
  @ExceptionHandler({FormatoRutException.class})
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public
  @ResponseBody
  ErrorDTO handle(Exception ex) {
    return new ErrorDTO("Rut mal formado", "400");
  }


}
