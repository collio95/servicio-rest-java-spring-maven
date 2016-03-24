package com.principal.services.rest.common.dto.perfil.inversionista;

import com.principal.services.rest.common.dto.BaseDTO;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
public class PerfilDTO extends BaseDTO {

  private ClasificacionDTO clasificacion;
  private Long puntaje;

  public ClasificacionDTO getClasificacion() {
    return clasificacion;
  }

  public void setClasificacion(ClasificacionDTO clasificacion) {
    this.clasificacion = clasificacion;
  }

  public Long getPuntaje() {
    return puntaje;
  }

  public void setPuntaje(Long puntaje) {
    this.puntaje = puntaje;
  }
}
