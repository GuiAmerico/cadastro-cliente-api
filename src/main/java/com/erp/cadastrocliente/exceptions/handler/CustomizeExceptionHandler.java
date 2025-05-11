package com.erp.cadastrocliente.exceptions.handler;

import com.erp.cadastrocliente.exceptions.AbstractException;
import com.erp.cadastrocliente.exceptions.dto.ExcecaoResponse;
import com.erp.cadastrocliente.exceptions.enums.TipoExcecao;
import java.util.Arrays;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice
public class CustomizeExceptionHandler {

  @ExceptionHandler(AbstractException.class)
  public ResponseEntity<ExcecaoResponse> handleExceptionAbstractException(
    AbstractException ex
  ) {
    log.error(this.causedIn(ex));
    return new ResponseEntity<>(new ExcecaoResponse(ex), ex.getStatus());
  }
  @ExceptionHandler(MethodArgumentNotValidException.class)
  protected ResponseEntity<ExcecaoResponse> handleMethodArgumentNotValid(
    MethodArgumentNotValidException ex) {
    String[] errors = ex.getBindingResult().getAllErrors().stream()
      .map(e -> ((FieldError) e).getField() + " -> " + e.getDefaultMessage())
      .toArray(String[]::new);
    log.error(this.causedIn(ex));

    TipoExcecao requisicaoInvalida = TipoExcecao.REQUISICAO_INVALIDA;

    ExcecaoResponse excecaoResponse = new ExcecaoResponse(
      Arrays.toString(errors),
      requisicaoInvalida.getCodigo()
    );
    return new ResponseEntity<>(excecaoResponse, requisicaoInvalida.getStatus());

  }
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExcecaoResponse> handleAllException(
    Exception ex
  ) {
    log.error(this.causedIn(ex));
    TipoExcecao unexpectedError = TipoExcecao.ERRO_INTERNO;
    ExcecaoResponse excecaoResponse = new ExcecaoResponse(
      ex.getMessage(),
      unexpectedError.getCodigo()
    );
    return new ResponseEntity<>(excecaoResponse, unexpectedError.getStatus());
  }


  private String causedIn(Exception ex) {
    StringBuilder cause = new StringBuilder();
    StackTraceElement ste = ex.getStackTrace()[0];
    cause
      .append("Classe: ")
      .append(ste.getClassName()).append(" -  Linha: ")
      .append(ste.getLineNumber())
      .append(" - Mensagem: ")
      .append(ex.getMessage());
    return cause.toString();
  }

}
