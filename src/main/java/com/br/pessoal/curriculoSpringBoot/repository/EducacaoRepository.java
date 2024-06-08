package com.br.pessoal.curriculoSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.pessoal.curriculoSpringBoot.model.Educacao;

public interface EducacaoRepository extends JpaRepository<Educacao, Long> {
    
}
