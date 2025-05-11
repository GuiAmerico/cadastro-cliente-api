package com.erp.cadastrocliente.controller;

import com.erp.cadastrocliente.controller.request.EnderecoRequest;
import com.erp.cadastrocliente.controller.response.EnderecoResponse;
import com.erp.cadastrocliente.service.EnderecoService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/clientes/{clienteId}/enderecos")
public class EnderecoController {

  private final EnderecoService enderecoService;
  @PostMapping
  public ResponseEntity<Void> adicionarEndereco(
    @PathVariable Long clienteId,
    @RequestBody @Valid EnderecoRequest request
  ) {
    enderecoService.adicionarEndereco(clienteId, request);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<List<EnderecoResponse>> buscarEnderecosPorCliente(
    @PathVariable Long clienteId
  ) {
    List<EnderecoResponse> enderecos = enderecoService.buscarEnderecosPorCliente(clienteId);
    return ResponseEntity.ok(enderecos);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> atualizarEndereco(
    @PathVariable Long clienteId,
    @PathVariable Long id,
    @RequestBody @Valid EnderecoRequest request
  ) {
    enderecoService.atualizarEndereco(id, request);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarEndereco(
    @PathVariable Long id,
    @PathVariable Long clienteId
  ) {
    enderecoService.deletarEndereco(id);
    return ResponseEntity.noContent().build();
  }
}
