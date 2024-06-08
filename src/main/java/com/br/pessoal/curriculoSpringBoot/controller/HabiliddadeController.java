package com.br.pessoal.curriculoSpringBoot.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.pessoal.curriculoSpringBoot.model.Habilidade;
import com.br.pessoal.curriculoSpringBoot.service.HabilidadeService;

@RestController
@RequestMapping("/api/habilidades")
public class HabiliddadeController {
    
    @Autowired HabilidadeService habilidadeService;

    //getById
    @GetMapping("/{id}")
    public ResponseEntity<Habilidade> getByIdHabilidade(@PathVariable Long id) {
        Optional<Habilidade> habilidadeOptional = habilidadeService.findById(id);

        if (habilidadeOptional.isPresent()) {
            return ResponseEntity.ok(habilidadeOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //getAll
    @GetMapping
    public List<Habilidade> getHabilidades() {
        return habilidadeService.findAll();
    }

    //post
    @PostMapping
    public Habilidade creatHabilidade(@RequestBody Habilidade habilidade) {
        return habilidadeService.save(habilidade);
    }

    //put
    @PutMapping("/{id}")
    public ResponseEntity<Habilidade> updatedHabilidade(@PathVariable Long id, @RequestBody Habilidade habilidadeAlterada) {
        Optional<Habilidade> habilidadeOptional = habilidadeService.findById(id);

        if (habilidadeOptional.isPresent()) {
            var habilidadeAtualizada = habilidadeOptional.get();
            habilidadeAtualizada.setNome(habilidadeAlterada.getNome());
            return ResponseEntity.ok(habilidadeService.save(habilidadeAtualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //deleteById
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByIdHabilidade(@PathVariable Long id) {
        Optional<Habilidade> habilidadeOptional = habilidadeService.findById(id);

        if (habilidadeOptional.isPresent()) {
            habilidadeService.deleteById(id);
            return ResponseEntity.ok("Habilidade deletada com sucesso");
        } else {
            return ResponseEntity.status(404).body("Habilidade não encontrada");
        }
    }
}
