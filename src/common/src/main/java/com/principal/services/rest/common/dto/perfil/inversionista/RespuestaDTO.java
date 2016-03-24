package com.principal.services.rest.common.dto.perfil.inversionista;

import com.principal.services.rest.common.dto.BaseDTO;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
public class RespuestaDTO extends BaseDTO {


  private Long id;
  private Long posicion;
  private String decripcion;
  private Boolean seleccionada;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getPosicion() {
    return posicion;
  }

  public void setPosicion(Long posicion) {
    this.posicion = posicion;
  }

  public String getDecripcion() {
    return decripcion;
  }

  public void setDecripcion(String decripcion) {
    this.decripcion = decripcion;
  }

  public Boolean getSeleccionada() {
    return seleccionada;
  }

  public void setSeleccionada(Boolean seleccionada) {
    this.seleccionada = seleccionada;
  }
}
