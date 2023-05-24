package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.entity.Movimentacao;
import br.com.uniamerica.estacionamento.repository.CondutorRepository;

import br.com.uniamerica.estacionamento.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;


@Service
public class CondutorService {

    @Autowired
    private CondutorRepository condutorRepository;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;


    @Transactional(rollbackFor =  Exception.class)
    public ResponseEntity<String> cadastrar(final Condutor condutor) {

        String regexTelefone = "\\+\\d{2}\\(\\d{3}\\)\\d{5}-\\d{4}";
        String regexCpf = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$";

        Assert.isTrue(condutor.getNome() != null , "ERRO: Nenhum nome foi inserido!");
        Assert.isTrue(condutor.getNome().length() > 2, "ERRO: Nenhum nome foi fornecido");
        Assert.isTrue(condutor.getCpf() != null, "ERRO: CPF não informado!");
        Assert.isTrue(condutor.getCpf().matches(regexCpf), "ERRO: CPF inválido!");
        Assert.isTrue(this.condutorRepository.findCpf(condutor.getCpf()).isEmpty(), "ERRO: CPF já cadastrado.");
        Assert.isTrue(condutor.getTelefone() != null, "ERRO: Insira o telefone!");
        Assert.isTrue(condutor.getTelefone().matches(regexTelefone), "Mascara de telefone invalida");
        Assert.isTrue(this.condutorRepository.findTelefone(condutor.getTelefone()).isEmpty(), "Telefone já existente.");


        this.condutorRepository.save(condutor);
        return ResponseEntity.ok("Registro realizado com sucesso");
    }


    @Transactional(rollbackFor =  Exception.class)
    public void editar(final Condutor condutor){

        String regexTelefone = "\\+\\d{2}\\(\\d{3}\\)\\d{5}-\\d{4}";
        String regexCpf = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$";

        final Condutor condutorBanco = this.condutorRepository.findById(condutor.getId()).orElse(null);

        Assert.isTrue(condutor.getTelefone() != null, "Error digite um telefone");
        Assert.isTrue(!condutor.getTelefone().matches(regexTelefone), "Mascara de telefone invalida");
        Assert.isTrue(this.condutorRepository.findTelefone(condutor.getTelefone()).isEmpty(), "Telefone já existente.");
        Assert.isTrue(condutorBanco != null || !condutorBanco.getId().equals(condutor.getId()),"Nao foi possivel identificar o registro");
        Assert.isTrue(condutor.getCpf() != null, "CPF, nao informado");
        Assert.isTrue(condutorRepository.findCpf(condutor.getCpf()).isEmpty(), "CPF ja exixte");
        Assert.isTrue(condutor.getCpf().matches(regexCpf), "Error cpf com mascara errada");

        this.condutorRepository.save(condutor);
    }

    @Transactional(rollbackFor =  Exception.class)
    public void deletar (final Condutor condutor){
        final Condutor condutorBanco = this.condutorRepository.findById(condutor.getId()).orElse(null);

        List<Movimentacao> movimentacaoList = this.condutorRepository.findMovimentacaoByCondutor(condutorBanco);

        if(movimentacaoList.isEmpty()) {
            this.condutorRepository.delete(condutorBanco);
        }else{
            condutorBanco.setAtivo(false);
            this.condutorRepository.save(condutor);
        }

    }




}