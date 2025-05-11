package com.erp.cadastrocliente.controller;

import com.erp.cadastrocliente.controller.request.LoginRequest;
import com.erp.cadastrocliente.controller.response.LoginRespose;
import com.erp.cadastrocliente.service.LoginService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/publico/v1/autenticacao")
public class LoginController {

  private final LoginService loginService;

  @PostMapping("/login")
  public ResponseEntity<LoginRespose> efetuarLogin(
    @RequestBody @Valid LoginRequest request
  ) {
    return ResponseEntity.ok(loginService.efetuarLogin(request));
  }
}
