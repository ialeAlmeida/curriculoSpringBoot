package com.br.pessoal.curriculoSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.pessoal.curriculoSpringBoot.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
}
