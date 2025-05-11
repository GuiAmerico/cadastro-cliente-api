package com.erp.cadastrocliente.exceptions.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum TipoExcecao {

  EMAIL_JA_CADASTRADO("001", "Email já cadastrado", HttpStatus.CONFLICT),
  CLIENTE_NAO_ENCONTRADO("002", "Cliente não encontrado", HttpStatus.NOT_FOUND),
  REQUISICAO_INVALIDA("003", "Requisição inválida", HttpStatus.BAD_REQUEST),
  ERRO_INTERNO("004", "Erro interno", HttpStatus.INTERNAL_SERVER_ERROR),
  ;

  private final String codigo;
  private final String descricao;
  private final HttpStatus status;

}
