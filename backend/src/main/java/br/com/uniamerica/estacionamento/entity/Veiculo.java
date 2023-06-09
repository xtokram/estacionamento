package br.com.uniamerica.estacionamento.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "tb_veiculos", schema = "public")

public class Veiculo extends AbstractEntity{
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "modelo")
    private Modelo modelo;
    @Getter

    @Column(name = "placa", nullable = true, unique = true)
    private String placa;

    @Getter @Setter
    @Column(name = "ano", nullable = true)
    private int ano;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = true)
    private Tipo tipo;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "cor", nullable = true)
    private Cor cor;
}

