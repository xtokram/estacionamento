package br.com.uniamerica.estacionamento.controller;


import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.repository.CondutorRepository;
import br.com.uniamerica.estacionamento.service.CondutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects.*;

@Controller
@RequestMapping(value = "/api/condutor")
public class CondutorController {

    @Autowired
    public CondutorRepository condutorRepository;

    @Autowired
    public CondutorService condutorService;


    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdParam(@PathVariable("id") final Long id){
        final Condutor condutor = this.condutorRepository.findById(id).orElse(null);

        return condutor == null ? ResponseEntity.badRequest().body("Condutor não encontrado!")
                : ResponseEntity.ok(condutor);
    }

    @GetMapping("/lista")
    public ResponseEntity<?> listaCompleta(){
        return ResponseEntity.ok(this.condutorRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> cadastrar (@RequestBody final Condutor condutor) {

        try{
            this.condutorService.cadastrar(condutor);
            return ResponseEntity.ok("Condutor Cadastrado.");
        } catch (DataIntegrityViolationException erro){
            return ResponseEntity.badRequest().body(erro.getMessage());
        } catch (RuntimeException erro){
            return ResponseEntity.badRequest().body(erro.getMessage());
        } catch (Exception erro){
            return ResponseEntity.badRequest().body(erro.getMessage());
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editar (@PathVariable("id") final Long id, @RequestBody final Condutor condutor){
        try{
            final Condutor condutorData = this.condutorRepository.findById(id).orElse(null);

            if(condutorData == null || !condutorData.getId().equals(condutor.getId())){
                throw new RuntimeException("Registro não identificado");
            }

            this.condutorRepository.save(condutor);
            return ResponseEntity.ok("Registro atualizado");
        }catch (DataIntegrityViolationException ex){
            return ResponseEntity.internalServerError().body("Error"+ex.getCause().getMessage());
        }catch (RuntimeException ex){
            return ResponseEntity.internalServerError().body("Erro"+ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") final Long id){
        final Condutor condutorData = this.condutorRepository.findById(id).orElse(null);

        try{
            this.condutorService.deletar(condutorData);
            return ResponseEntity.ok("Registro deletado");
        }catch (RuntimeException erro){
            return ResponseEntity.internalServerError().body("Erro"+erro.getMessage());
        }
    }
}