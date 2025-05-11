package com.erp.cadastrocliente.exceptions;


import com.erp.cadastrocliente.exceptions.enums.TipoExcecao;

public class RecursoJaExisteException extends AbstractException {

  public RecursoJaExisteException(TipoExcecao tipoExcecao) {
    super(tipoExcecao);
  }
}
