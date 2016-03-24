package com.principal.services.rest.common.dto.timbre;

import com.principal.services.rest.common.dto.BaseDTO;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
public class TimbreDTO extends BaseDTO {

  private Long id;
  private ImagenDTO imagen;
  private TipoDocumentoDTO tipoDocumento;

  private Long x;
  private Long y;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ImagenDTO getImagen() {
    return imagen;
  }

  public void setImagen(ImagenDTO imagen) {
    this.imagen = imagen;
  }

  public TipoDocumentoDTO getTipoDocumento() {
    return tipoDocumento;
  }

  public void setTipoDocumento(TipoDocumentoDTO tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
  }

  public Long getX() {
    return x;
  }

  public void setX(Long x) {
    this.x = x;
  }

  public Long getY() {
    return y;
  }

  public void setY(Long y) {
    this.y = y;
  }
}
