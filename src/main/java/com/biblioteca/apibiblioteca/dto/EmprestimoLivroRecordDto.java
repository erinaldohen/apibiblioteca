package com.biblioteca.apibiblioteca.dto;

import com.biblioteca.apibiblioteca.model.Emprestimo;
import com.biblioteca.apibiblioteca.model.Livro;

public record EmprestimoLivroRecordDto(Livro livro, Emprestimo emprestimo) {

}
