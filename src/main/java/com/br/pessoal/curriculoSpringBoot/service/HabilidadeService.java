package com.br.pessoal.curriculoSpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.pessoal.curriculoSpringBoot.model.Habilidade;
import com.br.pessoal.curriculoSpringBoot.repository.HabilidadeRepository;

@Service
public class HabilidadeService {
    
    @Autowired HabilidadeRepository habilidadeRepository;

    //findById
    public Optional<Habilidade> findById(Long id) {
        return habilidadeRepository.findById(id);
    }

    //findAll
    public List<Habilidade> findAll() {
        return habilidadeRepository.findAll();
    }

    //save
    public Habilidade save(Habilidade habilidade) {
        return habilidadeRepository.save(habilidade);
    }

    //deleteById
    public void deleteById(Long id) {
        habilidadeRepository.deleteById(id);
    }
}
