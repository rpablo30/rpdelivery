package com.api.rpfood.services;

import com.api.rpfood.models.PedidoConcluido;
import com.api.rpfood.repositories.PedidoConcluidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoConcluidoService {

    private final PedidoConcluidoRepository pedidoConcluidoRepository;

    @Autowired
    public PedidoConcluidoService(PedidoConcluidoRepository pedidoConcluidoRepository) {
        this.pedidoConcluidoRepository = pedidoConcluidoRepository;
    }

    public List<PedidoConcluido> listarTodosPedidosConcluidos() {
        return pedidoConcluidoRepository.findAll();
    }

    public Optional<PedidoConcluido> buscarPedidoConcluidoPorId(Long id) {
        return pedidoConcluidoRepository.findById(id);
    }


    public void salvarPedidoConcluido(PedidoConcluido pedidoConcluido) {
        pedidoConcluidoRepository.save(pedidoConcluido);
    }

}
