package com.principal.services.rest.common.dto.timbre;

import com.principal.services.rest.common.dto.BaseDTO;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
public class DocumentoDTO extends BaseDTO {

  private String codigo;
  private String base64;
  private Integer[] paginas;

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getBase64() {
    return base64;
  }

  public void setBase64(String base64) {
    this.base64 = base64;
  }

  public Integer[] getPaginas() {
    return paginas;
  }

  public void setPaginas(Integer[] paginas) {
    this.paginas = paginas;
  }
}
