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
@Table(name = "educacoes")
@Getter
@Setter
@AllArgsConstructor
public class Educacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String tipo;
    private int anoConclusao;
    private int semestre;
    private String instituicao;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa; 

    public Educacao(String nome, String tipo, int anoConclusao, int semestre, String instituicao) {
        this.nome = nome;
        this.tipo = tipo;
        this.anoConclusao = anoConclusao;
        this.semestre = semestre;
        this.instituicao = instituicao;
    }

    @Override
    public String toString() {
        return String.format("""
                %s em %s
                %d.%d - %s
                """, tipo, nome, anoConclusao, semestre, instituicao);
    }
}
