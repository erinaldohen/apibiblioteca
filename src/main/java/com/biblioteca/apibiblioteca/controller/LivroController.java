package com.biblioteca.apibiblioteca.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.apibiblioteca.dto.LivroRecordDto;
import com.biblioteca.apibiblioteca.model.Livro;
import com.biblioteca.apibiblioteca.repository.LivroRepository;

@RestController
public class LivroController {
    @Autowired
    LivroRepository livroRepository;

    @PostMapping("/livros")
    public ResponseEntity<Livro> cadastraLivro(@RequestBody LivroRecordDto livroRecordDto){
        Livro livro = new Livro();
        BeanUtils.copyProperties(livroRecordDto, livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroRepository.save(livro));
    }
}
