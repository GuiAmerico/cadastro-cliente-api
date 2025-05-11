package com.erp.cadastrocliente.repository;

public interface EnderecoRepositoryEntityManager {
    void atualizarEndereco(Long enderecoId, String logradouro);
    void deletarEndereco(Long enderecoId);
    void adicionarEndereco(Long clienteId, String logradouro);
}
