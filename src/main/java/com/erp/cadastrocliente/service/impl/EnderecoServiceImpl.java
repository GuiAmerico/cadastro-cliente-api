package com.erp.cadastrocliente.service.impl;

import com.erp.cadastrocliente.controller.request.EnderecoRequest;
import com.erp.cadastrocliente.controller.response.EnderecoResponse;
import com.erp.cadastrocliente.exceptions.RecursoNaoEncontradoException;
import com.erp.cadastrocliente.exceptions.enums.TipoExcecao;
import com.erp.cadastrocliente.repository.ClienteRepository;
import com.erp.cadastrocliente.repository.EnderecoRepository;
import com.erp.cadastrocliente.service.EnderecoService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EnderecoServiceImpl implements EnderecoService {

  private final EnderecoRepository enderecoRepository;
  private final ClienteRepository clienteRepository;
  private final ModelMapper mapper;

  @Override
  public void adicionarEndereco(Long clienteId, EnderecoRequest request) {
    boolean clienteEncontrado = clienteRepository.existsById(clienteId);
    if (!clienteEncontrado) {
      throw new RecursoNaoEncontradoException(TipoExcecao.CLIENTE_NAO_ENCONTRADO);
    }
    enderecoRepository.adicionarEndereco(clienteId, request.getLogradouro());
  }

  @Override
  public List<EnderecoResponse> buscarEnderecosPorCliente(Long clienteId) {
    return enderecoRepository.findAllByClienteId(clienteId)
      .stream()
      .map(endereco -> mapper.map(endereco, EnderecoResponse.class))
      .collect(Collectors.toList());
  }

  @Override
  public void atualizarEndereco(Long id, EnderecoRequest request) {
    enderecoRepository.atualizarEndereco(id, request.getLogradouro());
  }

  @Override
  public void deletarEndereco(Long id) {
    enderecoRepository.deletarEndereco(id);
  }
}
