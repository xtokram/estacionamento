package br.com.uniamerica.estacionamento.repository;

import br.com.uniamerica.estacionamento.entity.Condutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CondutorRepository extends JpaRepository<Condutor, Long> {

    @Query("SELECT condutor FROM condutores WHERE condutor.ativo = true")
    public List<Condutor> findByCondutoresAtivos();
}
