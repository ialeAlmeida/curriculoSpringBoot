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

import com.br.pessoal.curriculoSpringBoot.model.Pessoa;
import com.br.pessoal.curriculoSpringBoot.service.PessoaService;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
    
    @Autowired PessoaService pessoaService;

    //getOne
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getByIdPessoa(Long id) {
        Optional<Pessoa> pessoaOptional = pessoaService.findById(id);

        if (pessoaOptional.isPresent()) {
            return ResponseEntity.ok(pessoaOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //getAll
    @GetMapping
    public List<Pessoa> getPessoas() {
        return pessoaService.findAll();
    }

    //post
    @PostMapping
    public Pessoa creatPessoa(Pessoa pessoa) {
        return pessoaService.save(pessoa);
    }

    //put
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> updatedPessoa(@PathVariable Long id, @RequestBody Pessoa pessoaAlterada) {
        Optional<Pessoa> pessoaOptional = pessoaService.findById(id);
        if (pessoaOptional.isPresent()) {
            var pessoaAtualizada = pessoaOptional.get();
            pessoaAtualizada.setNome(pessoaAlterada.getNome());
            pessoaAtualizada.setCargoAlmejado(pessoaAlterada.getCargoAlmejado());
            pessoaAtualizada.setContato(pessoaAlterada.getContato());
            pessoaAtualizada.setIdade(pessoaAlterada.getIdade());;
            pessoaAtualizada.setCidade(pessoaAlterada.getCidade());
            pessoaAtualizada.setEstado(pessoaAlterada.getEstado());
            pessoaAtualizada.setEmail(pessoaAlterada.getEmail());
            pessoaAtualizada.setGitHub(pessoaAlterada.getGitHub());
            return ResponseEntity.ok(pessoaService.save(pessoaAtualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByIdPessoa(@PathVariable Long id){
        Optional<Pessoa> pessoaOptional = pessoaService.findById(id);

        if (pessoaOptional.isPresent()) {
            pessoaService.deleteById(id);
            return ResponseEntity.ok("Pessoa deletada com sucesso");
        } else {
            return ResponseEntity.status(404).body("Pessoa não encontrada");
        }

    }
}
