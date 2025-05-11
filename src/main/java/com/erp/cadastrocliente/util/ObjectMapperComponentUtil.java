package com.erp.cadastrocliente.util;

import com.erp.cadastrocliente.exceptions.ErroInternoException;
import com.erp.cadastrocliente.exceptions.enums.TipoExcecao;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public final class ObjectMapperComponentUtil {

  private final ObjectMapper mapper;


  public String objectParaJson(Object object) {
    try {
      return mapper.writeValueAsString(object);
    } catch (Exception e) {
      throw new ErroInternoException(TipoExcecao.ERRO_INTERNO);
    }
  }

}
