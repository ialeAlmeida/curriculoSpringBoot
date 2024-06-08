package com.br.pessoal.curriculoSpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.pessoal.curriculoSpringBoot.model.Educacao;
import com.br.pessoal.curriculoSpringBoot.repository.EducacaoRepository;

@Service
public class EducacaoService {
    
    @Autowired EducacaoRepository educacaoRepository;

    //findByID
    public Optional<Educacao> findById(Long id) {
        return educacaoRepository.findById(id);
    }

    //findAll
    public List<Educacao> findAll() {
        return educacaoRepository.findAll();
    }

    //save
    public Educacao save(Educacao educacao) {
        return educacaoRepository.save(educacao);
    }

    //deleteById
    public void deleteById(Long id) {
        educacaoRepository.deleteById(id);
    }
}
