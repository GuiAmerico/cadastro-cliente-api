package com.erp.cadastrocliente.controller.response;

import com.erp.cadastrocliente.util.AppUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteResponse {

  private Long id;
  private String nome;
  private String email;
  private String logotipo;

  public void setLogotipo(byte[] logotipo) {
    this.logotipo = AppUtil.binaryToBase64(logotipo);
  }
}