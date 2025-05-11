package com.erp.cadastrocliente.service;

import com.erp.cadastrocliente.controller.request.LoginRequest;
import com.erp.cadastrocliente.controller.response.LoginRespose;

public interface LoginService {

  LoginRespose efetuarLogin(LoginRequest request);

}
