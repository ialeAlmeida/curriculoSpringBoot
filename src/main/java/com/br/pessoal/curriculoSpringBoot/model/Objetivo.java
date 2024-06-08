package com.br.pessoal.curriculoSpringBoot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "objetivos")
@Getter
@Setter
@AllArgsConstructor
public class Objetivo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;
}
