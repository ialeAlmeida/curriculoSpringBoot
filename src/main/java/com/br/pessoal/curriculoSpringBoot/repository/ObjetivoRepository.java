package com.br.pessoal.curriculoSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.pessoal.curriculoSpringBoot.model.Objetivo;

public interface ObjetivoRepository extends JpaRepository<Objetivo, Long> {
    
}
