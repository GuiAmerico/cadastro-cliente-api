package com.erp.cadastrocliente.controller.response;

import java.util.List;
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
  private byte[] logotipo;
  private List<EnderecoResponse> enderecos;
}