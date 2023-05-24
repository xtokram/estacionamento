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


    @GetMapping
    public ResponseEntity<?> findByIdParam(@RequestParam("id") final Long id){
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
            return ResponseEntity.ok("Registro realizado com sucesso.");
        } catch (DataIntegrityViolationException erro){
            return ResponseEntity.badRequest().body(erro.getMessage());
        } catch (RuntimeException erro){
            return ResponseEntity.badRequest().body(erro.getMessage());
        } catch (Exception erro){
            return ResponseEntity.badRequest().body(erro.getMessage());
        }

    }
    @PutMapping
    public ResponseEntity<?> editar (@RequestParam("id") final Long id, @RequestBody final Condutor condutor){
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

    @DeleteMapping
    public ResponseEntity<?> delete (@RequestParam("id") final Long id){
        final Condutor condutorData = this.condutorRepository.findById(id).orElse(null);

        try{
            this.condutorService.deletar(condutorData);
            return ResponseEntity.ok("Registro deletado");
        }catch (RuntimeException erro){
            return ResponseEntity.internalServerError().body("Erro"+erro.getMessage());
        }
    }
}