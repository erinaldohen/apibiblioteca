package com.biblioteca.apibiblioteca.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Estudante implements Serializable {
    private static final long serialversionUID = 1L;

    @Id
    @NotBlank
    private String matricula;
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    @Column(unique = true)
    private String email;
    @NotBlank
    private String senha;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estudante") // mappedBy é o lado não proprietário da relação
    private List<Emprestimo> emprestimos;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public Estudante(){
        // Construtor vazio
    }

    public Estudante(@NotBlank String matricula, @NotBlank String nome, @NotBlank @Email String email,
            @NotBlank String senha, Endereco endereco) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }

    public Estudante(@NotBlank String matricula, @NotBlank String nome, @NotBlank @Email String email,
            @NotBlank String senha, List<Emprestimo> emprestimos) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.emprestimos = emprestimos;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Estudante [matricula=" + matricula + ", nome=" + nome + ", email=" + email + ", senha=" + senha
                + ", emprestimos=" + emprestimos + ", endereco=" + endereco + "]";
    }

}