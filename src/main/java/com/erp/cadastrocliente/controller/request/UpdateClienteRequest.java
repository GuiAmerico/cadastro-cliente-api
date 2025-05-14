package com.erp.cadastrocliente.controller.request;

import java.util.List;
import javax.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateClienteRequest {

  private String nome;
  @Email(message = "Email inválido")
  private String email;
  private MultipartFile logotipo;
  private List<EnderecoRequest> enderecos;

}