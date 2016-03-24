package com.principal.services.rest.common.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
public class ClienteSinPerfilException extends Exception {

  public ClienteSinPerfilException() {
    super("Cliente no tiene perfil creado.");
  }

  public ClienteSinPerfilException(Exception e) {
    super("Cliente no tiene perfil creado. Error: " + e.getMessage(), e);
  }
}
