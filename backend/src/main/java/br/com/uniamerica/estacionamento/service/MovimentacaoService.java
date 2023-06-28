package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.Recibo;
import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.entity.Configuracao;
import br.com.uniamerica.estacionamento.entity.Movimentacao;
import br.com.uniamerica.estacionamento.repository.CondutorRepository;
import br.com.uniamerica.estacionamento.repository.ConfiguracaoRepository;
import br.com.uniamerica.estacionamento.repository.MovimentacaoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private ConfiguracaoRepository configuracaoRepository;

    @Autowired
    private CondutorRepository condutorRepository;

    @Transactional
    public void cadastrar(Movimentacao movimentacao){

        Assert.isTrue(movimentacao.getVeiculo() != null, "Veiculo nao informado");
        Assert.isTrue(movimentacao.getCondutor() != null, "Condutor nao informada");
        Assert.isTrue(movimentacao.getEntrada() != null, "Entradada nao informado");

        this.movimentacaoRepository.save(movimentacao);

    }

    @Transactional
    public void editar(final Long id, Movimentacao movimentacao){

        Assert.isTrue(movimentacao.getVeiculo() != null, "Veiculo nao informado");
        Assert.isTrue(movimentacao.getCondutor() != null, "Condutor nao informada");
        Assert.isTrue(movimentacao.getEntrada() != null, "Entradada nao informado");

        final Movimentacao moviBanco = this.movimentacaoRepository.findById(id).orElse(null);
        Assert.isTrue(moviBanco != null, "nao foi possivel encontrar o registro");


        this.movimentacaoRepository.save(movimentacao);
    }
    @Transactional(rollbackFor = Exception.class)
    public Recibo saida(final Long id){

        Movimentacao movimentacao = this.movimentacaoRepository.findById(id).orElse(null);

        Assert.isTrue(movimentacao.getSaida() == null, "Movimentação já Finalizada.");

        movimentacao.setSaida(LocalDateTime.now());

        Long tempoTotal = movimentacao.getEntrada().until(movimentacao.getSaida(), ChronoUnit.HOURS);

        movimentacao.setTempo(tempoTotal);

        Configuracao configuracao = this.configuracaoRepository.findById(1L).orElse(null);

        BigDecimal horas = new BigDecimal(movimentacao.getTempo());

        BigDecimal valorTotal = configuracao.getValorHora().multiply(horas);

        movimentacao.setValorTotal(valorTotal);

        Long desconto = movimentacao.getTempo() / configuracao.getTempoParaDesconto();

        movimentacao.setValorDesconto(desconto);

        System.out.println(desconto);

        BigDecimal calculo = new BigDecimal(desconto).multiply(configuracao.getTempoDeDesconto());

        BigDecimal total = movimentacao.getValorTotal().subtract(calculo);

        movimentacao.setValorTotal(total);

        this.movimentacaoRepository.save(movimentacao);

        return new Recibo(movimentacao.getEntrada(), movimentacao.getSaida(), movimentacao.getCondutor(), movimentacao.getVeiculo(), movimentacao.getTempo(), configuracao.getTempoParaDesconto(), movimentacao.getValorTotal(), movimentacao.getValorDesconto());
    }

    @Transactional
    public void deletar(final Movimentacao movimentacao){
        final Movimentacao moviBanco = this.movimentacaoRepository.findById(movimentacao.getId()).orElse(null);

        moviBanco.setAtivo(Boolean.FALSE);
        this.movimentacaoRepository.save(movimentacao);
    }


}