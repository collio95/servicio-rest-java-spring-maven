package com.principal.services.rest.common.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
public class ServiceException extends Exception {

  public ServiceException(String e) {
    super("Ha ocurrido un error al realizar la petición. Error: " + e);
  }

  public ServiceException(Exception e) {
    super("Ha ocurrido un error al realizar la petición. Error: " + e.getMessage(), e);
  }
}
