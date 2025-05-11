package com.erp.cadastrocliente.service;

import com.erp.cadastrocliente.controller.request.EnderecoRequest;
import com.erp.cadastrocliente.controller.response.EnderecoResponse;
import java.util.List;

public interface EnderecoService {


  void adicionarEndereco(Long clienteId, EnderecoRequest request);

  List<EnderecoResponse> buscarEnderecosPorCliente(Long clienteId);

  void atualizarEndereco(Long id, EnderecoRequest request);

  void deletarEndereco(Long id);

}
