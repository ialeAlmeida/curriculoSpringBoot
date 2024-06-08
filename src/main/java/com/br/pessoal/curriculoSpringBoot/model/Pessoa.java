package com.br.pessoal.curriculoSpringBoot.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pessoas")
@Getter
@Setter
@AllArgsConstructor
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private int idade;
    private String cargoAlmejado;
    private String contato;
    private String cidade;
    private String estado;
    private String email;
    private String gitHub;

    @OneToMany(mappedBy = "pessoas",cascade = CascadeType.ALL)
    private List<Objetivo> objetivos = new ArrayList<>();
}
