package com.biblioteca.apibiblioteca.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EmprestimoLivro implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livro_isbn")
    private Livro livro;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emprestimo_id")
    private Emprestimo emprestimo;
    
    public EmprestimoLivro() {
    }

    public EmprestimoLivro(Livro livro, Emprestimo emprestimo) {
        this.livro = livro;
        this.emprestimo = emprestimo;
    }

    public int getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EmprestimoLivro other = (EmprestimoLivro) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "EmprestimoLivro [id=" + id + ", livro=" + livro + ", emprestimo=" + emprestimo + "]";
    }
}