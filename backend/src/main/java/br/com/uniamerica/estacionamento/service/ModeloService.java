package br.com.uniamerica.estacionamento.service;


import br.com.uniamerica.estacionamento.entity.Modelo;
import br.com.uniamerica.estacionamento.entity.Veiculo;
import br.com.uniamerica.estacionamento.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    @Transactional(rollbackFor = Exception.class)
    public void cadastro(final Modelo modelo){

        Assert.isTrue(modelo.getMarca() != null, "Sem marca.");
        Assert.isTrue(!modelo.getNome().isBlank(), "Erro, nome vazio.");

        this.modeloRepository.save(modelo);
    }

    @Transactional(rollbackFor = Exception.class)
    public void editar(final Modelo modelo){
        final Modelo modeloBanco = this.modeloRepository.findById(modelo.getId()).orElse(null);

        Assert.isTrue(modelo.getMarca() != null, "Sem marca.");
        Assert.isTrue(modelo.getNome() != null, "Digite um nome");

        this.modeloRepository.save(modelo);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deletar(final Modelo modelo){
        final Modelo modeloBanco = this.modeloRepository.findById(modelo.getId()).orElse(null);

        List<Veiculo> modeloLista = this.modeloRepository.findVeiculoByModelo(modeloBanco);

        if(modeloLista.isEmpty()){
            this.modeloRepository.delete(modeloBanco);
        }else {
            modeloBanco.setAtivo(false);
            this.modeloRepository.save(modelo);
        }
    }
}