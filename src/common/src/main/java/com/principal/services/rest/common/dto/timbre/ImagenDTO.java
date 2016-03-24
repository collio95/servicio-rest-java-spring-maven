package com.principal.services.rest.common.dto.timbre;

import com.principal.services.rest.common.dto.BaseDTO;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
public class ImagenDTO extends BaseDTO {

  private Long id;
  private String titulo;
  private String base64;
  private Long ancho;
  private Long alto;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getBase64() {
    return base64;
  }

  public void setBase64(String base64) {
    this.base64 = base64;
  }

  public Long getAncho() {
    return ancho;
  }

  public void setAncho(Long ancho) {
    this.ancho = ancho;
  }

  public Long getAlto() {
    return alto;
  }

  public void setAlto(Long alto) {
    this.alto = alto;
  }

}
