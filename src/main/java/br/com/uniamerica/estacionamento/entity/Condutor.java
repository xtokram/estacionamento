package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Table(name = "condutores",schema = "public")
public class Condutor extends AbstractEntity{

        @Getter @Setter
        @Column(name = "nome",nullable = false,length = 50)
        private String nome;
        @Getter @Setter
        @Column(name = "cpf",nullable = false,length = 20)
        private String cpf;
        @Getter @Setter
        @Column(name = "telefone",nullable = false,length = 20)
        private String telefone;
        @Getter @Setter
        @Column(name = "tempoPago")
        private BigDecimal tempoPago;
        @Getter @Setter
        @Column(name = "tempoDesconto")
        private LocalTime tempoDesconto;

    public Condutor() {
    }

    public Condutor(String nome, String cpf, String telefone, BigDecimal tempoPago, LocalTime tempoDesconto){
            this.setNome(nome);
            this.setCpf(cpf);
            this.setTelefone(telefone);
            this.setTempoPago(tempoPago);
            this.setTempoDesconto(tempoDesconto);
        }

}

