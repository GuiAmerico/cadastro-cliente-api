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
  ENDERECO_NAO_ENCONTRADO("005", "Endereco não encontrado", HttpStatus.NOT_FOUND),
  USUARIO_NAO_ENCONTRADO("006", "Usuário não encontrado", HttpStatus.NOT_FOUND),
  ACESSO_NEGADO("007", "Acesso negado", HttpStatus.FORBIDDEN)
  ;

  private final String codigo;
  private final String descricao;
  private final HttpStatus status;

}
