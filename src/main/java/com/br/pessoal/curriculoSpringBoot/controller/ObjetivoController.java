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

import com.br.pessoal.curriculoSpringBoot.model.Objetivo;
import com.br.pessoal.curriculoSpringBoot.service.ObjetivoService;

@RestController
@RequestMapping("/api/objetivos")
public class ObjetivoController {
    
    @Autowired ObjetivoService objetivoService;

    //getById
    @GetMapping("/{id}")
    public ResponseEntity<Objetivo> getByIdObjetivo(Long id) {
        Optional<Objetivo> objetivoOptional = objetivoService.findById(id);

        if(objetivoOptional.isPresent()) {
            return ResponseEntity.ok(objetivoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //getAll
    @GetMapping
    public List<Objetivo> getObjetivos() {
        return objetivoService.findAll();
    }

    @PostMapping
    //post
    public Objetivo creatObjetivo(Objetivo objetivo) {
        return objetivoService.save(objetivo);
    }


    //put
    @PutMapping("/{id}")
    public ResponseEntity<Objetivo> updatedObjetivo(@PathVariable Long id, @RequestBody Objetivo objetivoAlterado) {
        Optional<Objetivo> objetivoOptional = objetivoService.findById(id);

        if (objetivoOptional.isPresent()) {
            var objetivoAtualizado = objetivoOptional.get();
            objetivoAtualizado.setDescricao(objetivoAlterado.getDescricao());
            return ResponseEntity.ok(objetivoService.save(objetivoAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //deleteById
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<Objetivo> objetivoOptional = objetivoService.findById(id);

        if (objetivoOptional.isPresent()) {
            objetivoService.deleteById(id);
            return ResponseEntity.ok("Objetivo deletado com sucesso.");
        } else {
            return ResponseEntity.status(404).body("Objetivo não encontrado");
        }
    }
}
