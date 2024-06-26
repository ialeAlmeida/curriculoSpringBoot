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

    @OneToMany
    private List<Objetivo> objetivos = new ArrayList<>();

    @OneToMany
    private List<Educacao> educacoes = new ArrayList<>();

    @OneToMany
    private List<Experiencia> experiencias = new ArrayList<>();

    @OneToMany
    private List<Habilidade> habilidades = new ArrayList<>();

    public Pessoa(String nome, int idade, String cargoAlmejado, String contato, String cidade, String estado, String email, String gitHub) {
        this.nome = nome;
        this.idade = idade;
        this.cargoAlmejado = cargoAlmejado;
        this.contato = contato;
        this.cidade = cidade;
        this.estado = estado;
        this.email = email;
        this.gitHub = gitHub;
    }

    @Override
    public String toString() {
        return String.format("""
                %s
                Cargo/área: %s

                Informações pessoais:
                   - %s
                   - %d anos
                   - %s - %s
                   - %s
                   - %s

                """, nome, cargoAlmejado, contato, idade, cidade, estado, email, gitHub);
    }
}
