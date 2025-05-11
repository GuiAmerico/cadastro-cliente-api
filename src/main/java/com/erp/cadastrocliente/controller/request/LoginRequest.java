package com.erp.cadastrocliente.controller.request;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LoginRequest {

  @NotBlank(message = "Email não pode ser vazio")
  private String email;
  @NotBlank(message = "Senha não pode ser vazio")
  private String senha;
}
