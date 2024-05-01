package com.biblioteca.apibiblioteca.dto;

import java.time.LocalDateTime;
import com.biblioteca.apibiblioteca.model.Estudante;
import com.biblioteca.apibiblioteca.model.Livro;
import com.biblioteca.apibiblioteca.model.Usuario;

public record EmprestimoRecordDto(LocalDateTime dataDoEmprestimo, LocalDateTime dataDaEntrega, Usuario usuario, Livro livro,
            Estudante estudante) {

}