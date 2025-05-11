package com.erp.cadastrocliente.exceptions;

import com.erp.cadastrocliente.exceptions.enums.TipoExcecao;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class AbstractException extends RuntimeException {

  private final String codigo;
  private final HttpStatus status;

  protected AbstractException(TipoExcecao tipoExcecao) {
    super(tipoExcecao.getDescricao());
    this.codigo = tipoExcecao.getCodigo();
    this.status = tipoExcecao.getStatus();
  }
}
