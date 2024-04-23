package com.api.rpfood.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "itens_pedido_concluido")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemPedidoConcluido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_concluido_id")
    private PedidoConcluido pedidoConcluido;

    public ItemPedidoConcluido() {
    }

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private BigDecimal price;

    @Column
    private String imagem;

    @Column(nullable = false)
    private int quantidade;
}
