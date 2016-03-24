package com.principal.services.rest.common.exceptions;

/**
 * Created by e999676 on 07-01-2016.
 */
public class FormatoRutException extends Exception {

  public FormatoRutException() {
    super("Formato de rut invalido");
  }

  public FormatoRutException(Exception e) {
    super("Url mal formada. Error: " + e.getMessage(), e);
  }

}
