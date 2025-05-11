package com.erp.cadastrocliente.controller.request;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnderecoRequest {

  @NotBlank(message = "Logradouro não pode ser vazio")
  private String logradouro;
}