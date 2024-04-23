package com.api.rpfood.controllers;

import com.api.rpfood.models.Pedidos;
import com.api.rpfood.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "http://localhost:4200")
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }


    @PostMapping
    public ResponseEntity<Pedidos> criarPedido(@RequestBody Pedidos pedido) {
        try {
            System.out.println("Pedido recebido no backend: " + pedido.toString());

            Pedidos novoPedido = pedidoService.criarPedido(pedido);

            System.out.println("Pedido criado com sucesso: " + novoPedido.toString());

            return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro ao processar o pedido: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Pedidos>> listarPedidosPorStatus(@RequestParam(required = false) String status) {
        System.out.println("Parâmetro 'status' recebido: " + status);

        try {
            List<Pedidos> pedidos;
            if (status != null) {
                pedidos = pedidoService.listarPedidosPorStatus(status);

                // Adicione log para verificar os itens do pedido após a recuperação
                for (Pedidos pedido : pedidos) {
                    System.out.println("Pedido ID: " + pedido.getId() + ", Itens do Pedido: " + pedido.getItensDoPedido());
                }
            } else {
                pedidos = pedidoService.listarTodosPedidos();
            }
            return new ResponseEntity<>(pedidos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Pedidos> atualizarStatus(@PathVariable Long id, @RequestBody Pedidos novoPedido) {
        try {
            // Verificar se o ID do pedido é válido
            if (id == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            // Buscar o pedido no banco de dados pelo ID
            Optional<Pedidos> optionalPedido = pedidoService.buscarPedidoPorId(id);

            if (optionalPedido.isPresent()) {
                Pedidos pedido = optionalPedido.get();

                // Atualizar o status do pedido
                pedido.setStatus(novoPedido.getStatus());  // Aqui você pode ajustar conforme necessário

                // Salvar o pedido atualizado no banco de dados
                Pedidos pedidoAtualizado = pedidoService.atualizarPedido(pedido);

                return new ResponseEntity<>(pedidoAtualizado, HttpStatus.OK);
            } else {
                // Retornar BAD_REQUEST quando o ID não for encontrado
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }






}
