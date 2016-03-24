package com.principal.services.rest.common.dto.perfil.inversionista;

import com.principal.services.rest.common.dto.BaseDTO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
public class PreguntaDTO extends BaseDTO {

  private Long id;
  private Long posicion;
  private String descripcion;

  private List<RespuestaDTO> respuestas;

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

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public List<RespuestaDTO> getRespuestas() {
    return respuestas;
  }

  public void setRespuestas(List<RespuestaDTO> respuestas) {
    this.respuestas = respuestas;
  }
}
