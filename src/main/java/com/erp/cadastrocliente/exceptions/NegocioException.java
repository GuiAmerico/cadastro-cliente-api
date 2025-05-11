package com.erp.cadastrocliente.exceptions;


import com.erp.cadastrocliente.exceptions.enums.TipoExcecao;

public class NegocioException extends AbstractException {


  public NegocioException(TipoExcecao tipoExcecao) {
    super(tipoExcecao);
  }
}
