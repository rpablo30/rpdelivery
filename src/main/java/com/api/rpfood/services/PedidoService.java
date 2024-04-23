package com.api.rpfood.services;

import com.api.rpfood.models.ItemPedido;
import com.api.rpfood.models.Pedidos;
import com.api.rpfood.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
    public Optional<Pedidos> buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id);
    }
    public List<Pedidos> listarTodosPedidos() {
        List<Pedidos> pedidos = pedidoRepository.findAll();

        // Para cada pedido, associe os IDs dos itens
        pedidos.forEach(Pedidos::associarItensDoPedidoIds);

        return pedidos;
    }


    public Pedidos criarPedido(Pedidos pedido) {
        try {
            if (pedido.getItensDoPedido() == null || pedido.getItensDoPedido().isEmpty()) {
                throw new RuntimeException("Pedido deve ter pelo menos um item.");
            }

            // Definindo o status como "Pendente" antes de salvar
            pedido.setStatus("Pendente");

            // Associando o pedido a cada item do pedido e definindo pedidoId
            pedido.getItensDoPedido().forEach(item -> {
                item.setPedido(pedido);
                item.setPedidoId(pedido.getId());
            });

            // Calculando o valor total com base nos itens do pedido
            BigDecimal valorTotal = pedido.getItensDoPedido().stream()
                    .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantidade())))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            pedido.setValorTotal(valorTotal);

            // Adicionando log antes de salvar
            System.out.println("Salvando pedido no banco de dados...");

            // Salvando o pedido no banco de dados
            Pedidos pedidoSalvo = pedidoRepository.save(pedido);

            // Adicionando log após salvar
            System.out.println("Pedido salvo com sucesso.");

            return pedidoSalvo;
        } catch (Exception e) {
            // Adicionando log em caso de exceção
            System.err.println("Erro ao criar pedido: " + e.getMessage());

            // Lançando uma exceção mais específica com uma mensagem informativa
            throw new RuntimeException("Erro ao criar o pedido. Por favor, tente novamente mais tarde.");
        }
    }

    public List<Pedidos> listarPedidosPorStatus(String status) {
        try {
            List<Pedidos> pedidos = pedidoRepository.findByStatus(status);

            // Adicionando log para verificar os itens do pedido
            for (Pedidos pedido : pedidos) {
                System.out.println("Pedido ID: " + pedido.getId() + ", Itens do Pedido: " + pedido.getItensDoPedido());
            }

            return pedidos;
        } catch (Exception e) {
            // Adicionando log em caso de exceção
            System.err.println("Erro ao listar pedidos por status: " + e.getMessage());

            // Lança uma exceção mais específica com uma mensagem informativa
            throw new RuntimeException("Erro ao listar pedidos por status. Por favor, tente novamente mais tarde.");
        }
    }


    public Pedidos atualizarPedido(Pedidos pedido) {
        try {
            // Verificando se o pedido tem um ID válido
            if (pedido.getId() == null) {
                throw new RuntimeException("ID do pedido é nulo. O pedido deve ser persistido antes de atualizar.");
            }

            // Buscando o pedido no banco de dados pelo ID
            Optional<Pedidos> optionalPedido = pedidoRepository.findById(pedido.getId());

            if (optionalPedido.isPresent()) {
                Pedidos pedidoExistente = optionalPedido.get();

                // Atualizando os campos do pedido existente com os novos valores
                pedidoExistente.setClienteNome(pedido.getClienteNome());
                pedidoExistente.setClienteTelefone(pedido.getClienteTelefone());
                pedidoExistente.setClienteEndereco(pedido.getClienteEndereco());
                pedidoExistente.setFormaPagamento(pedido.getFormaPagamento());
                pedidoExistente.setTipoEntrega(pedido.getTipoEntrega());
                pedidoExistente.setTaxaEntrega(pedido.getTaxaEntrega());
                pedidoExistente.setStatus(pedido.getStatus());
                pedidoExistente.setValorTotal(pedido.getValorTotal());
                pedidoExistente.setDataHoraPedido(pedido.getDataHoraPedido());

                // Atualizando os itens do pedido
                List<ItemPedido> novosItens = pedido.getItensDoPedido();
                List<ItemPedido> itensExistentes = pedidoExistente.getItensDoPedido();

                // Limpando os itens existentes antes de adicionar os novos
                itensExistentes.clear();

                // Associando os itens do pedido ao pedido existente
                novosItens.forEach(item -> {
                    item.setPedido(pedidoExistente);
                    itensExistentes.add(item);
                });

                // Salvando o pedido atualizado no banco de dados
                return pedidoRepository.save(pedidoExistente);
            } else {
                // Retornando null ou lance uma exceção, dependendo do seu requisito
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar o pedido: " + e.getMessage());
        }
    }

    public void excluirPedido(Long id) {
        try {
            // Verificando se o ID do pedido é válido
            if (id == null) {
                throw new IllegalArgumentException("ID do pedido não pode ser nulo.");
            }

            // Verificando se o pedido existe no banco de dados
            Optional<Pedidos> optionalPedido = pedidoRepository.findById(id);

            if (optionalPedido.isPresent()) {
                // Removendo o pedido do banco de dados
                pedidoRepository.deleteById(id);

                // Adicionando log ou outras ações necessárias após excluir o pedido
                System.out.println("Pedido removido com sucesso.");
            } else {
                // Lançando uma exceção se o pedido não for encontrado
                throw new RuntimeException("Pedido não encontrado com o ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Adicionando log ou ações necessárias em caso de erro
            throw new RuntimeException("Erro ao excluir o pedido: " + e.getMessage());
        }
    }


}
