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

import com.br.pessoal.curriculoSpringBoot.model.Educacao;
import com.br.pessoal.curriculoSpringBoot.service.EducacaoService;

@RestController
@RequestMapping("/api/educacoes")
public class EducacaoController {
    
    @Autowired EducacaoService educacaoService;

    //getById
    @GetMapping("/{id}")
    public ResponseEntity<Educacao> getByIdEducacao(@PathVariable Long id) {
        Optional<Educacao> educacaoOptional = educacaoService.findById(id);

        if (educacaoOptional.isPresent()) {
            return ResponseEntity.ok(educacaoOptional.get());
        } else {
            return ResponseEntity.notFound().build();   
        }
    }

    //get
    @GetMapping
    public List<Educacao> getEducacoes() {
        return educacaoService.findAll();
    }

    //Post
    @PostMapping
    public Educacao creatEducacao(@RequestBody Educacao educacao) {
        return educacaoService.save(educacao);
    }
    //put
    @PutMapping("/{id}")
    public ResponseEntity<Educacao> updatedEducacao(@PathVariable Long id, @RequestBody Educacao educacaoAlterada) {
        Optional<Educacao> educacaoOptional = educacaoService.findById(id);

        if (educacaoOptional.isPresent()) {
            var educacaoAtualizada = educacaoOptional.get();
            educacaoAtualizada.setNome(educacaoAlterada.getNome());
            educacaoAtualizada.setTipo(educacaoAlterada.getTipo());
            educacaoAtualizada.setAnoConclusao(educacaoAlterada.getAnoConclusao());
            educacaoAtualizada.setSemestre(educacaoAlterada.getSemestre());
            educacaoAtualizada.setInstituicao(educacaoAlterada.getInstituicao());
            return ResponseEntity.ok(educacaoService.save(educacaoAtualizada));
        } else {
            return ResponseEntity.notFound().build();
        }

    }


    //deleteById
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByIdEducacao(@PathVariable Long id) {
        Optional<Educacao> educacaoOptional = educacaoService.findById(id);
    
        if (educacaoOptional.isPresent()) {
            educacaoService.deleteById(id);
            return ResponseEntity.ok("Educação deletada com sucesso");
        } else {
            return ResponseEntity.status(404).body("Educação não encontrada");
        }
    }

}
