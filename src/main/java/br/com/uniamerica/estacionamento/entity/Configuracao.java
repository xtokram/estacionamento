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
        @Column(name="valorHora", nullable = false)
        private BigDecimal valorHora;

        @Getter @Setter
        @Column(name="valorMinutoMulta", nullable = false)
        private BigDecimal valorMinutoMulta;

        @Getter @Setter
        @Column(name="inicioExpediente", nullable = false)
        private LocalTime inicioExpediente;

        @Getter @Setter
        @Column(name="fimExpediente", nullable = false)
        private LocalTime fimExpediente;

        @Getter @Setter
        @Column(name = "tempoParaDesconto", nullable = false)
        private LocalTime tempoParaDesconto;

        @Getter @Setter
        @Column(name="tempoDesconto", nullable = false)
        private LocalTime tempoDesconto;

        @Getter @Setter
        @Column(name="gerarDesconto", nullable = false)
        private boolean gerarDesconto;

        @Getter @Setter
        @Column(name="vagasMoto", nullable = false)
        private int vagasMoto;

        @Getter @Setter
        @Column(name="vagasCarro", nullable=false)
        private int vagasCarro;

        @Getter @Setter
        @Column(name="vagasVan", nullable = false)
        private int vagasVan;


        public Configuracao(){
        }

    public Configuracao(BigDecimal valorHora, BigDecimal valorMinutoMulta, LocalTime inicioExpediente, LocalTime fimExpediente,
                        LocalTime tempoParaDesconto, LocalTime tempoDesconto, boolean gerarDesconto, int vagasMoto, int vagasCarro, int vagasVan) {
        this.setValorHora(valorHora);
        this.setValorMinutoMulta(valorMinutoMulta);
        this.setInicioExpediente(inicioExpediente);
        this.setFimExpediente(fimExpediente);
        this.setTempoParaDesconto(tempoParaDesconto);
        this.setTempoDesconto(tempoDesconto);
        this.setGerarDesconto(gerarDesconto);
        this.setVagasMoto(vagasMoto);
        this.setVagasCarro(vagasCarro);
        this.setVagasMoto(vagasVan);
    }
}