package com.br.pessoal.curriculoSpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.pessoal.curriculoSpringBoot.model.Objetivo;
import com.br.pessoal.curriculoSpringBoot.repository.ObjetivoRepository;

@Service
public class ObjetivoService {
    
    @Autowired ObjetivoRepository objetivoRepository;

    //findById
    public Optional<Objetivo> findById(Long id) {
        return objetivoRepository.findById(id); 
    }

    //findALL
    public List<Objetivo> findAll() {
        return objetivoRepository.findAll();
    }

    //save
    public Objetivo save(Objetivo objetivo) {
        return objetivoRepository.save(objetivo);
    }

    //deleteById
    public void deleteById(Long id) {
        objetivoRepository.deleteById(id);
    }
}

