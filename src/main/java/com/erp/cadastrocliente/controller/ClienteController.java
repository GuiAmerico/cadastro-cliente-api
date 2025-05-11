package com.erp.cadastrocliente.controller;

import com.erp.cadastrocliente.controller.request.ClienteRequest;
import com.erp.cadastrocliente.controller.request.UpdateClienteRequest;
import com.erp.cadastrocliente.controller.response.ClienteResponse;
import com.erp.cadastrocliente.service.ClienteService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {

  private final ClienteService clienteService;

  @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<ClienteResponse> createCliente(@Valid @ModelAttribute ClienteRequest request) {
    ClienteResponse response = clienteService.createCliente(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<Void> updateCliente(
    @PathVariable Long id,
    @Valid @ModelAttribute UpdateClienteRequest request
  ) {
    clienteService.updateCliente(id, request);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
    clienteService.deleteCliente(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<ClienteResponse> findClienteById(@PathVariable Long id) {
    ClienteResponse response = clienteService.findClienteById(id);
    return ResponseEntity.ok(response);
  }

  @GetMapping
  public ResponseEntity<List<ClienteResponse>> findAllClientes() {
    List<ClienteResponse> response = clienteService.findAllClientes();
    return ResponseEntity.ok(response);
  }

}
