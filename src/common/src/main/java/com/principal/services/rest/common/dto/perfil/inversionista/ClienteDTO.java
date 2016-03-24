package com.principal.services.rest.common.dto.perfil.inversionista;

import com.principal.services.rest.common.dto.BaseDTO;

public class ClienteDTO extends BaseDTO {

  private int id;
  private String nombreCliente;
  private String appaternoCliente;
  private String apmaternoCliente;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombreCliente() {
    return nombreCliente;
  }

  public void setNombreCliente(String nombreCliente) {
    this.nombreCliente = nombreCliente;
  }

  public String getAppaternoCliente() {
    return appaternoCliente;
  }

  public void setAppaternoCliente(String appaternoCliente) {
    this.appaternoCliente = appaternoCliente;
  }

  public String getApmaternoCliente() {
    return apmaternoCliente;
  }

  public void setApmaternoCliente(String apmaternoCliente) {
    this.apmaternoCliente = apmaternoCliente;
  }

}
