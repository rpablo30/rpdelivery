package com.api.rpfood.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "pasteis")
public class Pastel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String descricao;
    private double price;
    private int opcionais;
    private Integer vendaSugestiva;
    private String imagem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOpcionais() {
        return opcionais;
    }

    public void setOpcionais(int opcionais) {
        this.opcionais = opcionais;
    }

    public Integer getVendaSugestiva() {
        return vendaSugestiva;
    }

    public void setVendaSugestiva(Integer vendaSugestiva) {
        this.vendaSugestiva = vendaSugestiva;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
