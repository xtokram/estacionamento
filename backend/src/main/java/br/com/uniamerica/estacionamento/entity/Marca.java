package br.com.uniamerica.estacionamento.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_marcas", schema = "public")
public class Marca extends AbstractEntity{
    @Getter
    @Column(name = "nome", nullable = true, unique = true)
    private String nome;
}

