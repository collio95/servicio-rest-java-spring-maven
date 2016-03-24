package com.principal.services.rest.common.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
public class ClienteNoExisteException extends Exception {

  public ClienteNoExisteException() {
    super("Cliente no existe");
  }

  public ClienteNoExisteException(Exception e) {
    super("Cliente no existe. Error: " + e.getMessage(), e);
  }
}
