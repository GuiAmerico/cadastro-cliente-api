package com.erp.cadastrocliente.repository;

import com.erp.cadastrocliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>, ClienteRepositoryEntityManager {

  boolean existsByEmail(String email);

}
