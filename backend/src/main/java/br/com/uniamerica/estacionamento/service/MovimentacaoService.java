package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.entity.Configuracao;
import br.com.uniamerica.estacionamento.entity.Movimentacao;
import br.com.uniamerica.estacionamento.repository.CondutorRepository;
import br.com.uniamerica.estacionamento.repository.ConfiguracaoRepository;
import br.com.uniamerica.estacionamento.repository.MovimentacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;

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
        Assert.isTrue(movimentacao.getSaida() != null, "Saida nao informada");

        this.movimentacaoRepository.save(movimentacao);

    }

    @Transactional
    public void editar(final Long id, Movimentacao movimentacao){

        Assert.isTrue(movimentacao.getVeiculo() != null, "Veiculo nao informado");
        Assert.isTrue(movimentacao.getCondutor() != null, "Condutor nao informada");
        Assert.isTrue(movimentacao.getEntrada() != null, "Entradada nao informado");
        Assert.isTrue(movimentacao.getSaida() != null, "Saida nao informada");

        final Movimentacao moviBanco = this.movimentacaoRepository.findById(id).orElse(null);
        Assert.isTrue(moviBanco != null, "nao foi possivel encontrar o registro");


        this.movimentacaoRepository.save(movimentacao);
    }
    @Transactional(rollbackOn = Exception.class)
    public void saida (final Long id){

        final Movimentacao movimentacao = this.movimentacaoRepository.findById(id).orElse(null);

        final Configuracao configuracao = this.configuracaoRepository.findById(1L).orElse(null);

        final Condutor condutor = this.condutorRepository.findById(movimentacao.getCondutor().getId()).orElse(null);




        Assert.isTrue(configuracao != null, "Configuração não encontrada.");
        Assert.isTrue(movimentacao != null, "Movimentação não encontrada.");


        movimentacao.setSaida(LocalDateTime.now());


        final LocalDateTime saida = LocalDateTime.now();

        Duration duracao = Duration.between(movimentacao.getEntrada(), saida);


        final BigDecimal horas = BigDecimal.valueOf(duracao.toHoursPart());

        final BigDecimal minutos = BigDecimal.valueOf(duracao.toMinutesPart()).divide(BigDecimal.valueOf(60), 2, RoundingMode.HALF_EVEN);

        BigDecimal preco = configuracao.getValorHora().multiply(horas).add(configuracao.getValorHora().multiply(minutos));

        movimentacao.setHora(duracao.toHoursPart());//O numero de horas da duração é atribuido ao atributo hora
        movimentacao.setMinutos(duracao.toMinutesPart());//O numero de minutos de duração é atribuido ao atributo minutos

        BigDecimal valor = configuracao.getValorHora().multiply(horas).add(configuracao.getValorHora().multiply(minutos));

        movimentacao.setValorTotal(valor);
        condutor.setTempoPago(valor);


        this.condutorRepository.save(condutor);

        this.movimentacaoRepository.save(movimentacao);
    }

    @Transactional
    public void deletar(final Movimentacao movimentacao){
        final Movimentacao moviBanco = this.movimentacaoRepository.findById(movimentacao.getId()).orElse(null);

        moviBanco.setAtivo(Boolean.FALSE);
        this.movimentacaoRepository.save(movimentacao);
    }
}