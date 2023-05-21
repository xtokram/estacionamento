package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="modelo", schema="public")
public class Modelo extends AbstractEntity{
    @Getter @Setter
    @Column(name="nome", nullable = false)
    private String nome;

    @Getter @Setter
    @JoinColumn(name="marca", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
    private Marca marca;

    public Modelo(){}

    public Modelo(String nome, Marca marca){
        this.setNome(nome);
        this.setMarca(marca);
    }
}
