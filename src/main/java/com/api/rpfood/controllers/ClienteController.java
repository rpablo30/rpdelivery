package com.api.rpfood.controllers;

import com.api.rpfood.models.Cliente;
import com.api.rpfood.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id) {
        return clienteService.getClienteById(id);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Cliente> adicionarCliente(@RequestBody Cliente cliente) {
        ResponseEntity<Cliente> response = clienteService.addCliente(cliente);

        if (response.getStatusCode() == HttpStatus.CREATED) {
            return response;
        } else {
            // Trate o erro de forma adequada, por exemplo, com um log
            System.out.println("Erro ao adicionar cliente: " + response.getBody());
            return ResponseEntity.status(response.getStatusCode()).body(null);
        }
    }


    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
    }

    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        return clienteService.updateCliente(id, clienteAtualizado);
    }
}
