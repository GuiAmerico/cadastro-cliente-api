package com.erp.cadastrocliente.controller.request;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClienteRequest {

  @NotBlank(message = "Nome não pode ser vazio")
  private String nome;
  @Email(message = "Email inválido")
  @NotBlank(message = "Email não pode ser vazio")
  private String email;
  @NotNull(message = "Logotipo não pode ser vazio")
  private MultipartFile logotipo;
  @NotEmpty(message = "Endereço não pode ser vazio")
  private List<EnderecoRequest> enderecos = new ArrayList<>();
}