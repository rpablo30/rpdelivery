package com.api.rpfood.services;

import com.api.rpfood.models.Cliente;
import com.api.rpfood.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ClienteService {


    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {
        try {
            System.out.println("Recebendo solicitação para adicionar cliente: " + cliente);

            // Certifique-se de que o id seja nulo antes de salvar
            cliente.setId(null);

            Cliente novoCliente = clienteRepository.save(cliente);

            System.out.println("Cliente adicionado com sucesso: " + novoCliente);

            return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
        } catch (DataIntegrityViolationException e) {
            // Trate a exceção de violação de integridade, por exemplo, campo duplicado
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            // Trate outras exceções de forma genérica
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }





    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente updateCliente(Long id, Cliente clienteAtualizado) {
        if (clienteRepository.existsById(id)) {
            clienteAtualizado.setId(id);
            return clienteRepository.save(clienteAtualizado);
        }
        return null;
    }
}
