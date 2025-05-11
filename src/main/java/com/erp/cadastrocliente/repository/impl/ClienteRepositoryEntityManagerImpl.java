package com.erp.cadastrocliente.repository.impl;

import com.erp.cadastrocliente.model.Cliente;
import com.erp.cadastrocliente.repository.ClienteRepositoryEntityManager;
import com.erp.cadastrocliente.util.ObjectMapperComponentUtil;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ClienteRepositoryEntityManagerImpl implements ClienteRepositoryEntityManager {

  private final ObjectMapperComponentUtil objectMapper;
  @PersistenceContext
  private EntityManager em;

  @Override
  @Transactional
  public Cliente criarClienteComEnderecos(Cliente cliente) {
    StoredProcedureQuery sp = em
      .createStoredProcedureQuery("sp_criar_cliente_com_enderecos", Cliente.class);
    sp.registerStoredProcedureParameter("nome", String.class, ParameterMode.IN);
    sp.registerStoredProcedureParameter("email", String.class, ParameterMode.IN);
    sp.registerStoredProcedureParameter("logotipo", byte[].class, ParameterMode.IN);
    sp.registerStoredProcedureParameter("enderecos_json", String.class, ParameterMode.IN);

    sp.setParameter("nome", cliente.getNome());
    sp.setParameter("email", cliente.getEmail());
    sp.setParameter("logotipo", cliente.getLogotipo());
    sp.setParameter("enderecos_json", objectMapper.objectParaJson(cliente.getEnderecos()));

    sp.execute();
    return (Cliente) sp.getSingleResult();
  }

  @Override
  @Transactional
  public void deletarCliente(Long clienteId) {
    StoredProcedureQuery sp = em
      .createStoredProcedureQuery("sp_deletar_cliente");
    sp.registerStoredProcedureParameter("cliente_id", Long.class, ParameterMode.IN);
    sp.setParameter("cliente_id", clienteId);
    sp.execute();
  }

  @Override
  @Transactional
  public void atualizarCliente(Cliente cliente) {
    StoredProcedureQuery sp = em
      .createStoredProcedureQuery("sp_atualizar_cliente");
    sp.registerStoredProcedureParameter("cliente_id", Long.class, ParameterMode.IN);
    sp.registerStoredProcedureParameter("nome", String.class, ParameterMode.IN);
    sp.registerStoredProcedureParameter("email", String.class, ParameterMode.IN);
    sp.registerStoredProcedureParameter("logotipo", byte[].class, ParameterMode.IN);

    sp.setParameter("cliente_id", cliente.getId());
    sp.setParameter("nome", cliente.getNome());
    sp.setParameter("email", cliente.getEmail());
    sp.setParameter("logotipo", cliente.getLogotipo());
    sp.execute();
  }
}
