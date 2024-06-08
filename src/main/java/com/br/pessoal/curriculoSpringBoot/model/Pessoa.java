package com.br.pessoal.curriculoSpringBoot.model;

import jakarta.persistence.Entity;
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
    private String nome;
    private int idade;
    private String cargoAlmejado;
    private String contato;
    private String cidade;
    private String estado;
    private String email;
    private String gitHub;
}
