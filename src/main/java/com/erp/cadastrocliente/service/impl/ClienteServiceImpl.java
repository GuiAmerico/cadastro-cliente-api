package com.erp.cadastrocliente.service.impl;

import com.erp.cadastrocliente.controller.request.ClienteRequest;
import com.erp.cadastrocliente.controller.request.UpdateClienteRequest;
import com.erp.cadastrocliente.controller.response.ClienteResponse;
import com.erp.cadastrocliente.exceptions.RecursoJaExisteException;
import com.erp.cadastrocliente.exceptions.RecursoNaoEncontradoException;
import com.erp.cadastrocliente.exceptions.enums.TipoExcecao;
import com.erp.cadastrocliente.model.Cliente;
import com.erp.cadastrocliente.repository.ClienteRepository;
import com.erp.cadastrocliente.service.ClienteService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

  private final ClienteRepository clienteRepository;
  private final ModelMapper mapper;

  @Override
  public ClienteResponse createCliente(ClienteRequest request) {
    validarEmail(request.getEmail());
    Cliente cliente = mapper.map(request, Cliente.class);
    Cliente clienteSalvo = clienteRepository.criarClienteComEnderecos(cliente);
    return mapper.map(clienteSalvo, ClienteResponse.class);
  }

  @Override
  public void updateCliente(Long id, UpdateClienteRequest request) {
    Cliente cliente = clienteRepository
      .findById(id)
      .orElseThrow(() -> new RecursoNaoEncontradoException(TipoExcecao.CLIENTE_NAO_ENCONTRADO));

    boolean atualizouEmail = !cliente.getEmail().equals(request.getEmail());
    if (atualizouEmail) {
      validarEmail(request.getEmail());
    }
    mapper.map(request, cliente);
    clienteRepository.atualizarCliente(cliente);

  }

  @Override
  public void deleteCliente(Long id) {
    clienteRepository.deletarCliente(id);
  }

  @Override
  public ClienteResponse findClienteById(Long id) {
    return clienteRepository
      .findById(id)
      .map(cliente -> mapper.map(cliente, ClienteResponse.class))
      .orElseThrow(() -> new RecursoNaoEncontradoException(TipoExcecao.CLIENTE_NAO_ENCONTRADO));
  }

  @Override
  public List<ClienteResponse> findAllClientes() {
    List<ClienteResponse> collect = clienteRepository
      .findAll()
      .stream()
      .map(cliente -> mapper.map(cliente, ClienteResponse.class))
      .collect(Collectors.toList());
    return collect;
  }

  private void validarEmail(String email) {
    boolean emailJaCadastrado = clienteRepository.existsByEmail(email);
    if (emailJaCadastrado) {
      throw new RecursoJaExisteException(TipoExcecao.EMAIL_JA_CADASTRADO);
    }
  }
}
