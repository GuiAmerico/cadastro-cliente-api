package com.erp.cadastrocliente.repository;

import com.erp.cadastrocliente.model.Cliente;

public interface ClienteRepositoryEntityManager {
    Cliente criarClienteComEnderecos(Cliente cliente);
    void deletarCliente(Long clienteId);
    void atualizarCliente(Cliente cliente);
}