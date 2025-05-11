package com.erp.cadastrocliente.repository;

import com.erp.cadastrocliente.model.Endereco;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>, EnderecoRepositoryEntityManager {

  List<Endereco> findAllByClienteId(Long clienteId);
}
