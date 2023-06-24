package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_modelos", schema = "public")
public class Modelo extends AbstractEntity{
    @Getter
    @Column(name = "nome", nullable = true, unique = true)
    private String nome;
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;
}