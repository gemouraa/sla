package com.example.aula.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    @NotBlank(message = "Sexo é obrigatório.")
    private String sexo;

    @NotBlank(message = "Idade é obrigatória.")
    private String idade;

    @NotBlank(message = "Altura é obrigatória.")
    private String altura;

    @NotBlank(message = "Peso é obrigatório.")
    private String peso;

    @NotBlank(message = "Posição é obrigatória.")
    private String posicao;

    private String numeroDaCamisa;

    // Construtor vazio
    public Usuario() {}

    // Construtor completo
    public Usuario(Long id, String nome, String sexo, String idade, String altura, String peso, String posicao, String numeroDaCamisa) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.posicao = posicao;
        this.numeroDaCamisa = numeroDaCamisa;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getIdade() {
        return idade;
    }
    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getAltura() {
        return altura;
    }
    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }
    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getPosicao() {
        return posicao;
    }
    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getNumeroDaCamisa() {
        return numeroDaCamisa;
    }
    public void setNumeroDaCamisa(String numeroDaCamisa) {
        this.numeroDaCamisa = numeroDaCamisa;
    }
}
