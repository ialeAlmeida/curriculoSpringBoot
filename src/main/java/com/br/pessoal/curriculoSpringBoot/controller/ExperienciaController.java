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

import com.br.pessoal.curriculoSpringBoot.model.Experiencia;
import com.br.pessoal.curriculoSpringBoot.service.ExperienciaService;

@RestController
@RequestMapping("/api/experiencias")
public class ExperienciaController {
    
    @Autowired ExperienciaService experienciaService;

    //getById
    @GetMapping("/{id}")
    public ResponseEntity<Experiencia> getByIdExperiencia(@PathVariable Long id) {
        Optional<Experiencia> experienciaOptional = experienciaService.findById(id);

        if (experienciaOptional.isPresent()) {
            return ResponseEntity.ok(experienciaOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //getAll
    @GetMapping
    public List<Experiencia> getExperiencias() {
        return experienciaService.findAll();
    }

    //post
    @PostMapping
    public Experiencia creatExperiencia(@RequestBody Experiencia experiencia) {
        return experienciaService.save(experiencia);
    }


    //put
    @PutMapping("/{id}")
    public ResponseEntity<Experiencia> updatedExperiencia(@PathVariable Long id, @RequestBody Experiencia experienciaAlterada) {
        Optional<Experiencia> experienciaOptional = experienciaService.findById(id);

        if (experienciaOptional.isPresent()) {
            var experienciaAtualizada = experienciaOptional.get();
            experienciaAtualizada.setNome(experienciaAlterada.getNome());
            experienciaAtualizada.setAnoConclusao(experienciaAlterada.getAnoConclusao());
            experienciaAtualizada.setSemestre(experienciaAlterada.getSemestre());
            experienciaAtualizada.setInstituicao(experienciaAlterada.getInstituicao());
            experienciaAtualizada.setDescricao(experienciaAlterada.getDescricao());
            return ResponseEntity.ok(experienciaService.save(experienciaAtualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    //deleteById
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByIdExperiencia(@PathVariable Long id) {
        Optional<Experiencia> experienciaOptional = experienciaService.findById(id);

        if (experienciaOptional.isPresent()) {
            experienciaService.deleteById(id);
            return ResponseEntity.ok("Experiência deletada com sucesso");
        } else {
            return ResponseEntity.status(404).body("Experiência não encontrada");
        }
    }
}
