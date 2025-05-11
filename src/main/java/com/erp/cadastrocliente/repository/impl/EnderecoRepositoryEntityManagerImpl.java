package com.erp.cadastrocliente.repository.impl;

import com.erp.cadastrocliente.repository.EnderecoRepositoryEntityManager;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class EnderecoRepositoryEntityManagerImpl implements EnderecoRepositoryEntityManager {

  @PersistenceContext
  private EntityManager em;

  @Override
  public void atualizarEndereco(Long enderecoId, String logradouro) {
    StoredProcedureQuery sp = em
      .createStoredProcedureQuery("sp_atualizar_endereco");
    sp.registerStoredProcedureParameter("endereco_id", Long.class, ParameterMode.IN);
    sp.registerStoredProcedureParameter("logradouro", String.class, ParameterMode.IN);

    sp.setParameter("endereco_id", enderecoId);
    sp.setParameter("logradouro", logradouro);
    sp.execute();
  }

  @Override
  public void deletarEndereco(Long enderecoId) {
    StoredProcedureQuery sp = em
      .createStoredProcedureQuery("sp_deletar_endereco");
    sp.registerStoredProcedureParameter("endereco_id", Long.class, ParameterMode.IN);

    sp.setParameter("endereco_id", enderecoId);
    sp.execute();
  }

  @Override
  public void adicionarEndereco(Long clienteId, String logradouro) {
    StoredProcedureQuery sp = em
      .createStoredProcedureQuery("sp_adicionar_endereco");
    sp.registerStoredProcedureParameter("cliente_id", Long.class, ParameterMode.IN);
    sp.registerStoredProcedureParameter("logradouro", String.class, ParameterMode.IN);

    sp.setParameter("cliente_id", clienteId);
    sp.setParameter("logradouro", logradouro);
    sp.execute();
  }
}
