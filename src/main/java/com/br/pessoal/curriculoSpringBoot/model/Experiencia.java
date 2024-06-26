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
@Table(name = "experiencias")
@Getter
@Setter
@AllArgsConstructor
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private int anoConclusao;
    private int semestre;
    private String instituicao;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa; 

    public Experiencia(String nome, int anoConclusao, int semestre, String instituicao, String descricao) {
        this.nome = nome;
        this.anoConclusao = anoConclusao;
        this.semestre = semestre;
        this.instituicao = instituicao;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return String.format("""
                %s - %s
                %d.%d
                %s
                """, instituicao, nome, anoConclusao, semestre, descricao);
    }
}
