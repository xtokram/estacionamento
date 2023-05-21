package br.com.uniamerica.estacionamento.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="marca", schema="public")
public class Marca extends AbstractEntity{
    @Getter @Setter
    @Column(name="marca", nullable = false)
    private String nome;

    public Marca(){}

    public Marca(String nome){
        this.setNome(nome);
    }
}
