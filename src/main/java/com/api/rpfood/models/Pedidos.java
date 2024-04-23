package com.api.rpfood.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Setter
@Getter
@Table(name = "pedidos")
public class Pedidos {

    // Adicionando este construtor para inicializar a lista de itensDoPedido
    public Pedidos() {
        this.itensDoPedido = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Mapeamento adicional para armazenar IDs dos itensDoPedido
    @ElementCollection
    @CollectionTable(name = "pedido_itens_ids", joinColumns = @JoinColumn(name = "pedido_id"))
    @OrderColumn(name = "item_order")
    @Column(name = "item_id")
    private List<Long> itensDoPedidoIds;

    // Método para obter IDs dos itens do pedido
    public List<Long> getItensDoPedidoIds() {
        return itensDoPedidoIds;
    }


    // Método para associar IDs dos itens do pedido
    public void associarItensDoPedidoIds() {
        this.itensDoPedidoIds = this.itensDoPedido.stream()
                .map(ItemPedido::getId)
                .collect(Collectors.toList());
    }



    @Column(name = "clienteNome", columnDefinition = "VARCHAR(255) DEFAULT 'Nome Padrão'")
    private String clienteNome;

    @Column(nullable = true)
    private String clienteTelefone;

    @Column(nullable = true)
    private String clienteEndereco;

    @Column(nullable = false)
    private String formaPagamento;

    @Column(nullable = true)
    private String tipoEntrega;

    @Column(nullable = true)
    private BigDecimal taxaEntrega;

    @Column(nullable = true)
    private String status;

    @Column(nullable = true)
    private BigDecimal valorTotal;

    private String hoverStatus;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date dataHoraPedido;

    public String getHoverStatus() {
        return hoverStatus;
    }

    public void setHoverStatus(String hoverStatus) {
        this.hoverStatus = hoverStatus;
    }

    public Date getDataHoraPedido() {
        return dataHoraPedido;
    }

    public void setDataHoraPedido(Date dataHoraPedido) {
        this.dataHoraPedido = dataHoraPedido;
    }

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ItemPedido> itensDoPedido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getClienteTelefone() {
        return clienteTelefone;
    }

    public void setClienteTelefone(String clienteTelefone) {
        this.clienteTelefone = clienteTelefone;
    }

    public String getClienteEndereco() {
        return clienteEndereco;
    }

    public void setClienteEndereco(String clienteEndereco) {
        this.clienteEndereco = clienteEndereco;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public BigDecimal getTaxaEntrega() {
        return taxaEntrega;
    }

    public void setTaxaEntrega(BigDecimal taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemPedido> getItensDoPedido() {
        return itensDoPedido;
    }

    public void setItensDoPedido(List<ItemPedido> itensDoPedido) {
        this.itensDoPedido = itensDoPedido;
    }
}
