package com.erp.cadastrocliente.config.auth;

import com.erp.cadastrocliente.model.Usuario;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
public class FiltroAutenticacao extends OncePerRequestFilter {

  private final JwtComponent jwtComponent;
  private final UserDetailsService userDetailsService;

  @Override
  protected void doFilterInternal(
    @NonNull HttpServletRequest request,
    @NonNull HttpServletResponse response,
    @NonNull FilterChain filterChain
  ) throws ServletException, IOException {

    final String authHeader = request.getHeader("Authorization");
    final String authJwt;
    final String username;
    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
      filterChain.doFilter(request, response);
      return;
    }
    authJwt = authHeader.substring(7);
    if (jwtComponent.isTokenExpired(authJwt)) {
      response.setStatus(HttpServletResponse.SC_FORBIDDEN);
      filterChain.doFilter(request, response);
      return;

    }
    username = jwtComponent.extractUsername(authJwt);
    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      Usuario user = (Usuario) this.userDetailsService.loadUserByUsername(username);

      UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
        user,
        null,
        user.getAuthorities()
      );
      authToken.setDetails(
        new WebAuthenticationDetailsSource().buildDetails(request)
      );
      SecurityContextHolder.getContext().setAuthentication(authToken);
    }
    filterChain.doFilter(request, response);
  }

}
