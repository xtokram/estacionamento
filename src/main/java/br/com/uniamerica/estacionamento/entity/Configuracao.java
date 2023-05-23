package br.com.uniamerica.estacionamento.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Table(name="configuracoes", schema="public")
    public class Configuracao extends AbstractEntity{
    @Getter @Setter
    @Column(name = "valor_hora", nullable = true, unique = true)
    private BigDecimal valorHora;

    @Getter @Setter
    @Column(name = "valor_minuto_hora", nullable = true, unique = true)
    private BigDecimal valorMinutoMulta;

    @Getter @Setter
    @Column(name = "inicio_expediente", nullable = true, unique = true)
    private LocalTime inicioExpediente;

    @Getter @Setter
    @Column(name = "fim_expediente", nullable = true, unique = true)
    private LocalTime fimExpediente;

    @Getter @Setter
    @Column(name = "tempo_para_desconto", nullable = true, unique = true)
    private Integer tempoParaDesconto;

    @Getter @Setter
    @Column(name = "tempo_de_desconto", nullable = true, unique = true)
    private BigDecimal tempoDeDesconto;

    @Getter @Setter
    @Column(name = "gerar_desconto", nullable = true, unique = true)
    private Boolean gerarDesconto;

    @Getter @Setter
    @Column(name = "vagas_moto", nullable = true, unique = true)
    private Integer vagasMotos;

    @Getter @Setter
    @Column(name = "vagas_vans", nullable = true, unique = true)
    private Integer vagasVans;

    @Getter @Setter
    @Column(name = "vagas_carro", nullable = true, unique = true)
    private Integer vagasCarro;


    public Configuracao(){
    }

    public Configuracao(BigDecimal valorHora, BigDecimal valorMinutoMulta, LocalTime inicioExpediente, LocalTime fimExpediente,
                        Integer tempoParaDesconto, BigDecimal tempoDeDesconto, Boolean gerarDesconto, Integer vagasMotos,
                        Integer vagasVans, Integer vagasCarro) {
        this.setValorHora(valorHora);
        this.setValorMinutoMulta(valorMinutoMulta);
        this.setInicioExpediente(inicioExpediente);
        this.setFimExpediente(fimExpediente);
        this.setTempoParaDesconto(tempoParaDesconto);
        this.setTempoDeDesconto(tempoDeDesconto);
        this.setGerarDesconto(gerarDesconto);
        this.setVagasMotos(vagasMotos);
        this.setVagasVans(vagasVans);
        this.setVagasCarro(vagasCarro);
    }
}