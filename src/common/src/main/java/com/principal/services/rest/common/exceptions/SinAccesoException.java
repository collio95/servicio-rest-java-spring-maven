package com.principal.services.rest.common.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
public class SinAccesoException extends Exception {

  public SinAccesoException(String e) {
    super("Sin acceso. Error: " + e);
  }

  public SinAccesoException(Exception e) {
    super("Sin acceso. Error: " + e.getMessage(), e);
  }

}
