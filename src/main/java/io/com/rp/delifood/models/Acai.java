package io.com.rp.delifood.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "acai")
public class Acai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column
    private String descricao;

    @Column(nullable = false)
    private double price;

    @Column
    private int opcionais;

    @Column
    private String imagem;

    @Column(nullable = false)
    private String categoria;


}
