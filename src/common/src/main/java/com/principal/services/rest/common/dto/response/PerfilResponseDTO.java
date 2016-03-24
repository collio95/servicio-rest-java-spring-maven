package com.principal.services.rest.common.dto.response;

import com.principal.services.rest.common.dto.BaseDTO;
import com.principal.services.rest.common.dto.perfil.inversionista.PerfilDTO;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
public class PerfilResponseDTO extends BaseDTO {

  private String mensaje;
  private PerfilDTO perfil;

  public String getMensaje() {
    return mensaje;
  }

  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }

  public PerfilDTO getPerfil() {
    return perfil;
  }

  public void setPerfil(PerfilDTO perfil) {
    this.perfil = perfil;
  }
}
