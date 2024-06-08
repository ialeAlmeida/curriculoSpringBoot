package com.br.pessoal.curriculoSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.pessoal.curriculoSpringBoot.model.Experiencia;

public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> {
    
}
