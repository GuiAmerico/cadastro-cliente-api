package com.erp.cadastrocliente.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

  private final FiltroAutenticacao filtroAutenticacao;
  private final AuthenticationProvider authenticationProvider;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
      .csrf()
      .disable()
      .authorizeRequests()
      .antMatchers(devToolsMatcher()).permitAll()
      .antMatchers("/publico/**").permitAll()
      .anyRequest().authenticated()
      .and()
      .authenticationProvider(authenticationProvider)
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and()
      .addFilterBefore(filtroAutenticacao, UsernamePasswordAuthenticationFilter.class)
      .build();
  }


  private String[] devToolsMatcher() {
    return new String[]{
      "/swagger/**",
      "/swagger-ui/**",
      "/swagger-ui.html",
      "/swagger-resources/**",
      "/configuration/ui",
      "/configuration/security",
      "/webjars/**",
      "/v2/api-docs/**",
      "/v3/api-docs/**",
      "/h2-console/**",
      "/actuator/**"
    };
  }

}
