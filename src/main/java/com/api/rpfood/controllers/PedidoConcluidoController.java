package com.api.rpfood.controllers;

import com.api.rpfood.models.PedidoConcluido;
import com.api.rpfood.models.Pedidos;
import com.api.rpfood.services.PedidoConcluidoService;
import com.api.rpfood.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos-concluidos")
@CrossOrigin(origins = "http://localhost:4200")
public class PedidoConcluidoController {

    private final PedidoConcluidoService pedidoConcluidoService;
    private final PedidoService pedidoService;

    @Autowired
    public PedidoConcluidoController(PedidoConcluidoService pedidoConcluidoService, PedidoService pedidoService) {
        this.pedidoConcluidoService = pedidoConcluidoService;
        this.pedidoService = pedidoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoConcluido> buscarPedidoConcluidoPorId(@PathVariable Long id) {
        try {
            Optional<PedidoConcluido> pedidoConcluido = pedidoConcluidoService.buscarPedidoConcluidoPorId(id);
            return pedidoConcluido.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<PedidoConcluido>> listarPedidosConcluidos() {
        try {
            List<PedidoConcluido> pedidosConcluidos = pedidoConcluidoService.listarTodosPedidosConcluidos();

            // Adicione log para verificar os itens do pedido após a recuperação
            for (PedidoConcluido pedidoConcluido : pedidosConcluidos) {
                System.out.println("Pedido Concluído ID: " + pedidoConcluido.getId() + ", Itens do Pedido Concluído: " + pedidoConcluido.getItensDoPedidoConcluido());
            }

            return new ResponseEntity<>(pedidosConcluidos, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }









    @PostMapping("/enviar-relatorio")
    public ResponseEntity<String> enviarRelatorio(@RequestBody PedidoConcluido pedidoConcluido) {
        try {

            pedidoConcluidoService.salvarPedidoConcluido(pedidoConcluido);
            Long idPedido = pedidoConcluido.getId(); // Substitua pelo método correto para obter o ID do pedido
            pedidoService.excluirPedido(idPedido);

            return new ResponseEntity<>("Relatório enviado com sucesso", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Erro ao enviar o relatório: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
