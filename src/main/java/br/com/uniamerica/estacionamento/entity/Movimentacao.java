package br.com.uniamerica.estacionamento.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name="movimentacoes", schema="public")
public class Movimentacao extends AbstractEntity{
    @Getter @Setter
    @JoinColumn(name = "veiculos", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Veiculo veiculo;

    @Getter @Setter
    @JoinColumn(name="condutores", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Condutor condutor;

    @Getter @Setter
    @Column(name="Entrada", nullable = false)
    private LocalDateTime entrada;

    @Getter @Setter
    @Column(name="saida", nullable = false)
    private LocalDateTime saida;

    @Getter @Setter
    @Column(name="tempo", nullable = false)
    private LocalTime tempo;

    @Getter @Setter
    @Column(name="tempoDesconto", nullable = false)
    private LocalTime tempoDesconto;

    @Getter @Setter
    @Column(name="tempoMulta", nullable = false)
    private LocalTime tempoMulta;

    @Getter @Setter
    @Column(name="valorDesconto", nullable = false)
    private BigDecimal valorDesconto;

    @Getter @Setter
    @Column(name="valorMulta", nullable = false)
    private BigDecimal valorMulta;

    @Getter @Setter
    @Column(name="valorTotal", nullable = false)
    private BigDecimal valorTotal;

    @Getter @Setter
    @Column(name="valorHora", nullable = false)
    private BigDecimal valorHora;

    @Getter @Setter
    @Column(name="valorHoraMulta", nullable = false)
    private BigDecimal valorHoralMulta;

    public Movimentacao(){}

    public Movimentacao(Veiculo veiculo, Condutor condutor, LocalDateTime entrada,
                        LocalDateTime saida, LocalTime tempo, LocalTime tempoDesconto,
                        LocalTime tempoMulta, BigDecimal valorDesconto, BigDecimal valorMulta,
                        BigDecimal valorTotal, BigDecimal valorHora, BigDecimal valorHoralMulta) {
        this.setVeiculo(veiculo);
        this.setCondutor(condutor);
        this.setEntrada(entrada);
        this.setSaida(saida);
        this.setTempo(tempo);
        this.setTempoDesconto(tempoDesconto);
        this.setTempoMulta(tempoMulta);
        this.setValorDesconto(valorDesconto);
        this.setValorMulta(valorMulta);
        this.setValorTotal(valorTotal);
        this.setValorHora(valorHora);
        this.setValorHoralMulta(valorHoralMulta);
    }
}
