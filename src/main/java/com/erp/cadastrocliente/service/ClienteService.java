package com.erp.cadastrocliente.service;

import com.erp.cadastrocliente.controller.request.ClienteRequest;
import com.erp.cadastrocliente.controller.request.UpdateClienteRequest;
import com.erp.cadastrocliente.controller.response.ClienteResponse;
import java.util.List;

public interface ClienteService {


  ClienteResponse createCliente(ClienteRequest request);

  void updateCliente(Long id, UpdateClienteRequest request);

  void deleteCliente(Long id);

  ClienteResponse findClienteById(Long id);

  List<ClienteResponse> findAllClientes();
}
