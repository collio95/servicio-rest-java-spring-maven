package com.principal.services.rest.common.dto;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
public class ErrorDTO extends BaseDTO {

  private String mensaje;
  private DetalleErrorDTO error;

  public ErrorDTO(String detalle, String codigo) {
    this.mensaje = "Error";
    this.error = new DetalleErrorDTO(detalle, codigo);
  }

  public String getMensaje() {
    return mensaje;
  }

  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }

  public DetalleErrorDTO getError() {
    return error;
  }

  public void setError(DetalleErrorDTO error) {
    this.error = error;
  }
}
