package com.erp.cadastrocliente.exceptions;

import com.erp.cadastrocliente.exceptions.enums.TipoExcecao;

public class ErroInternoException extends AbstractException {

  public ErroInternoException(TipoExcecao tipoExcecao) {
    super(tipoExcecao);
  }
}
