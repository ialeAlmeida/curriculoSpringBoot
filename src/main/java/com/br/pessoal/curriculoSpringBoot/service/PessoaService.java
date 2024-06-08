package com.br.pessoal.curriculoSpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.pessoal.curriculoSpringBoot.model.Pessoa;
import com.br.pessoal.curriculoSpringBoot.repository.PessoaRepository;

@Service
public class PessoaService {
    
    @Autowired PessoaRepository pessoaRepository;

    //findById
    public Optional<Pessoa> findById(Long id) {
        return pessoaRepository.findById(id);
    }

    //findAll
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    //save
    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    //deleteById
    public void deleteById(Long id) {
        pessoaRepository.deleteById(id);
    }
}
