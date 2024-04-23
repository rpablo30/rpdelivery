package com.api.rpfood.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "pedido_concluido")
@JsonIgnoreProperties("itensDoPedidoConcluido")
public class PedidoConcluido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




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

    @Column(nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date dataHoraPedido;


    @OneToMany(mappedBy = "pedidoConcluido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedidoConcluido> itensDoPedidoConcluido;


    public PedidoConcluido() {
    }
}
