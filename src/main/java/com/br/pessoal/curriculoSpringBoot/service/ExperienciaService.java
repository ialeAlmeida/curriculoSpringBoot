package com.br.pessoal.curriculoSpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.pessoal.curriculoSpringBoot.model.Experiencia;
import com.br.pessoal.curriculoSpringBoot.repository.ExperienciaRepository;

@Service
public class ExperienciaService {
    
    @Autowired ExperienciaRepository experienciaRepository;

    //findById
    public Optional<Experiencia> findById(Long id) {
        return experienciaRepository.findById(id);
    }

    //findAll
    public List<Experiencia> findAll() {
        return experienciaRepository.findAll();
    }

    //save
    public Experiencia save(Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }

    //deleteById
    public void deleteById(Long id) {
        experienciaRepository.deleteById(id);
    }
}
