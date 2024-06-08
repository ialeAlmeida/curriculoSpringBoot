package com.br.pessoal.curriculoSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.pessoal.curriculoSpringBoot.model.Habilidade;

public interface HabilidadeRepository extends JpaRepository<Habilidade, Long> {
    
}
