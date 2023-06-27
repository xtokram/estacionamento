package br.com.uniamerica.estacionamento.repository;

import br.com.uniamerica.estacionamento.entity.Marca;
import br.com.uniamerica.estacionamento.entity.Modelo;
import br.com.uniamerica.estacionamento.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    @Query("from Veiculo where Modelo = :modelo")
    public List<Veiculo> findVeiculoByModelo(@Param("modelo") final Modelo modelo);

    @Query("from Modelo where nome = :nome")
    public List<Modelo> findNome(@Param("nome") final String nome);

    @Query("from Modelo where marca = :idMarca")
    public List<Modelo> findMarca(@Param("idMarca") final Marca idMarca);
}