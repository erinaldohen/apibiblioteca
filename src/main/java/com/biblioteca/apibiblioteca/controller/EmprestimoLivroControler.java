package com.biblioteca.apibiblioteca.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.apibiblioteca.dto.EmprestimoLivroRecordDto;
import com.biblioteca.apibiblioteca.model.EmprestimoLivro;
import com.biblioteca.apibiblioteca.repository.EmprestimoLivroRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin("*")
public class EmprestimoLivroControler {
    @Autowired
    EmprestimoLivroRepository emprestimoLivroRepository;

    @PostMapping("/listadelivros")
    public ResponseEntity<EmprestimoLivro> cadastraListaDeLivroNumEmprestimo(@RequestBody EmprestimoLivroRecordDto emprestimoLivroRecordDto) {
        EmprestimoLivro emprestimoLivro = new EmprestimoLivro();
        BeanUtils.copyProperties(emprestimoLivroRecordDto, emprestimoLivro);
        return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoLivroRepository.save(emprestimoLivro));
    }
}
