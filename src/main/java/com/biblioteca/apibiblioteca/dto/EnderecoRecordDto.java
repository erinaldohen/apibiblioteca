package com.biblioteca.apibiblioteca.dto;

import com.biblioteca.apibiblioteca.model.Estudante;

public record EnderecoRecordDto(String cep, String logradouro, String numero, String complemento, String bairro, String cidade,
            String uf, Estudante estudante) {

}
