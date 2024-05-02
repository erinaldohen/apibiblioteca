package com.biblioteca.apibiblioteca.dto;

import com.biblioteca.apibiblioteca.model.Estudante;
import com.biblioteca.apibiblioteca.model.Livro;
import com.biblioteca.apibiblioteca.model.Usuario;

public record EmprestimoRecordDto(String dataDoEmprestimo, String dataDaEntrega, 
                                Usuario usuario, Livro livro, Estudante estudante) {

}