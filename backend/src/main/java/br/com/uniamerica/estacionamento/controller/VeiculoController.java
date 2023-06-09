package br.com.uniamerica.estacionamento.controller;

import br.com.uniamerica.estacionamento.entity.Veiculo;
import br.com.uniamerica.estacionamento.repository.VeiculoRepository;
import br.com.uniamerica.estacionamento.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdParam(@PathVariable("id") final Long id){
        final Veiculo veiculo = veiculoRepository.findById(id).orElse(null);

        return veiculo == null
                ? ResponseEntity.badRequest().body("Nenhum modelo encontrado")
                : ResponseEntity.ok(veiculo);
    }

    @GetMapping("/lista")
    public ResponseEntity<?> listaCompleta(){
        return ResponseEntity.ok(this.veiculoRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Validated final Veiculo veiculo){

        try{
            this.veiculoService.cadastrar(veiculo);
            return ResponseEntity.ok("Registro realizado com sucesso");
        }catch (DataIntegrityViolationException erro){
            return ResponseEntity.internalServerError().body(erro.getMessage());
        } catch (RuntimeException erro){
            return ResponseEntity.internalServerError().body(erro.getMessage());
        } catch (Exception erro){
            return ResponseEntity.badRequest().body(erro.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") final Long id, @RequestBody final Veiculo veiculo){
        try{
            final Veiculo veiculoBanco = this.veiculoRepository.findById(id).orElse(null);

            if(veiculoBanco == null || !veiculoBanco.getId().equals(veiculo.getId())){
                throw new RuntimeException("Nao foi possivel identificar o registro no banco de dados");
            }

            this.veiculoRepository.save(veiculo);
            return ResponseEntity.ok("Registro atualizado");
        }catch (DataIntegrityViolationException erro){
            return ResponseEntity.internalServerError().body("Erro" + erro.getCause().getCause().getMessage());
        }catch (RuntimeException erro){
            return ResponseEntity.internalServerError().body("Erro" + erro.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") final Long id){
        final Veiculo veiculoBanco = this.veiculoRepository.findById(id).orElse(null);

        try{
            this.veiculoService.deletar(veiculoBanco);
            return ResponseEntity.ok("Registro deletado");
        }catch (RuntimeException erro){
            return ResponseEntity.internalServerError().body("Erro"+erro.getMessage());
        }
    }
}
