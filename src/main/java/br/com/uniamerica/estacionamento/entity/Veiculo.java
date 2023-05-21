package br.com.uniamerica.estacionamento.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="veiculos", schema="public")
public class Veiculo extends AbstractEntity{
    @Getter @Setter
    @Column(name="placa", nullable=false, unique = true)
    private String placa;

    @Getter @Setter
    @JoinColumn(name="modelo", nullable = false)
    @ManyToOne(fetch= FetchType.LAZY, cascade= CascadeType.ALL)
    private Modelo modelo;

    @Getter @Setter
    @Column(name="cor", nullable = false, length=20)
    @Enumerated(EnumType.STRING)
    private Cor cor;

    @Getter @Setter
    @Column(name="tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Getter @Setter
    @Column(name="ano", nullable = false)
    private int ano;

    public Veiculo(){}

    public Veiculo(String placa, Modelo modelo, Cor cor, Tipo tipo, int ano) {
        this.setPlaca(placa);
        this.setModelo(modelo);
        this.setCor(cor);
        this.setTipo(tipo);
        this.setAno(ano);
    }
}
