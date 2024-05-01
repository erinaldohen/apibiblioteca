package com.biblioteca.apibiblioteca.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Emprestimo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDateTime dataDoEmprestimo;
    private LocalDateTime dataDaEntrega;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "livro_isbn")
    private Livro livro;
    @ManyToOne
    @JoinColumn(name = "estudante_matricula")
    private Estudante estudante;
   
    public Emprestimo() {
    }

    public Emprestimo(LocalDateTime dataDoEmprestimo, LocalDateTime dataDaEntrega, Usuario usuario, Livro livro,
            Estudante estudante) {
        this.dataDoEmprestimo = dataDoEmprestimo;
        this.dataDaEntrega = dataDaEntrega;
        this.usuario = usuario;
        this.livro = livro;
        this.estudante = estudante;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDataDoEmprestimo() {
        return dataDoEmprestimo;
    }

    public void setDataDoEmprestimo(LocalDateTime dataDoEmprestimo) {
        this.dataDoEmprestimo = dataDoEmprestimo;
    }

    public LocalDateTime getDataDaEntrega() {
        return dataDaEntrega;
    }

    public void setDataDaEntrega(LocalDateTime dataDaEntrega) {
        this.dataDaEntrega = dataDaEntrega;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Emprestimo other = (Emprestimo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Emprestimo [id=" + id + ", dataDoEmprestimo=" + dataDoEmprestimo + ", dataDaEntrega=" + dataDaEntrega
                + ", usuario=" + usuario + ", livro=" + livro + ", estudante=" + estudante + "]";
    }
}