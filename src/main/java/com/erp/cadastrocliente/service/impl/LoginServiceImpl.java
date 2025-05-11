package com.erp.cadastrocliente.service.impl;

import com.erp.cadastrocliente.config.auth.JwtComponent;
import com.erp.cadastrocliente.controller.request.LoginRequest;
import com.erp.cadastrocliente.controller.response.LoginRespose;
import com.erp.cadastrocliente.exceptions.RecursoNaoEncontradoException;
import com.erp.cadastrocliente.exceptions.enums.TipoExcecao;
import com.erp.cadastrocliente.model.Usuario;
import com.erp.cadastrocliente.repository.UsuarioRepository;
import com.erp.cadastrocliente.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

  private final AuthenticationManager authenticationManager;
  private final JwtComponent jwtComponent;
  private final UsuarioRepository usuarioRepository;

  @Override
  public LoginRespose efetuarLogin(LoginRequest request) {
    Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
      .orElseThrow(
        () -> new RecursoNaoEncontradoException(TipoExcecao.USUARIO_NAO_ENCONTRADO)
      );
    UsernamePasswordAuthenticationToken authToken =
      new UsernamePasswordAuthenticationToken(
        request.getEmail(),
        request.getSenha()
      );

    authenticationManager.authenticate(authToken);

    String jwtToken = jwtComponent.gerarToken(usuario);
    return new LoginRespose(jwtToken);
  }
}
