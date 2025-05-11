package com.erp.cadastrocliente.exceptions;

import com.erp.cadastrocliente.exceptions.enums.TipoExcecao;

public class RecursoNaoEncontradoException extends AbstractException {

  public RecursoNaoEncontradoException(TipoExcecao tipoExcecao) {
    super(tipoExcecao);
  }
}
