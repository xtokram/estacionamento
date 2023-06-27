package br.com.uniamerica.estacionamento.repository;

import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.entity.Movimentacao;
import br.com.uniamerica.estacionamento.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

    @Query("from Movimentacao where veiculo = :veiculo")
    public List<Movimentacao> findVeiculo(@RequestParam("veiculo") final Veiculo veiculo);

    @Query("from Movimentacao where condutor = :condutor")
    public List<Movimentacao> findCondutor(@RequestParam("condutor") final Condutor condutor);
}