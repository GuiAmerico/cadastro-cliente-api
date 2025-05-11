package com.erp.cadastrocliente.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper mapper = new ModelMapper();
    mapper.getConfiguration().setSkipNullEnabled(true);
    mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

//    mapper.typeMap(ClienteRequest.class, Cliente.class)
//      .addMappings(m -> m.map(
//        ClienteRequest::getLogotipo,
//        (cliente, o) -> {
//          MultipartFile file = (MultipartFile) o;
//          byte[] logotipo = AppUtil.multipartFileToBinary(file);
//          cliente.setLogotipo(logotipo);
//        }
//      ));
//    mapper.typeMap(Cliente.class, ClienteResponse.class)
//      .addMappings(m -> m.map(
//        Cliente::getLogotipo,
//        (clienteResponse, o) -> {
//          if (o == null) {
//            return;
//          }
//          byte[] logotipo = (byte[]) o;
//          String logotipoBase64 = AppUtil.binaryToBase64(logotipo);
//          clienteResponse.setLogotipo(logotipoBase64);
//        }
//      ));

    return mapper;
  }

//  private ExpressionMap<Cliente, ClienteResponse> mapMultipartBinaryToBase64() {
//
//    return m -> m.map(
//      Cliente::getLogotipo,
//      (clienteResponse, o) -> {
//        if (o == null) {
//          return;
//        }
//        byte[] logotipo = (byte[]) o;
//        String logotipoBase64 = AppUtil.binaryToBase64(logotipo);
//        clienteResponse.setLogotipo(logotipoBase64);
//      }
//    );
//  }
//
//  private ExpressionMap<ClienteRequest, Cliente> mapMultipartFileToBinary() {
//    return m -> m.map(
//      ClienteRequest::getLogotipo,
//      (cliente, o) -> {
//        if (o == null) {
//          return;
//        }
//        MultipartFile file = (MultipartFile) o;
//        byte[] logotipo = AppUtil.multipartFileToBinary(file);
//        cliente.setLogotipo(logotipo);
//      }
//    );
//  }

}
