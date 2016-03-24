package com.principal.services.rest.common.dto;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
public class DetalleErrorDTO extends BaseDTO {

  private String detalle;
  private String codigo;

  public DetalleErrorDTO(String detalle, String codigo) {
    this.detalle = detalle;
    this.codigo = codigo;
  }

  public String getDetalle() {
    return detalle;
  }

  public void setDetalle(String detalle) {
    this.detalle = detalle;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }
}
