package com.biblioteca.apibiblioteca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/livros")
    public ResponseEntity<List<Livro>> listaTodosOsLivros(){
        return ResponseEntity.status(HttpStatus.OK).body(livroRepository.findAll());
    }

    @GetMapping("/livros/{isbn}")
    public ResponseEntity<Object> consultaLivroPorId(@PathVariable(name = "isbn") String isbn){
        Optional<Livro> uOptional = livroRepository.findById(isbn);
        if (uOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(uOptional.get());
    }

    @PutMapping("/livros/{isbn}")
    public ResponseEntity<Object> atualizaLivro(@PathVariable(name = "isnb") String isbn){
        Optional<Livro> uOptional = livroRepository.findById(isbn);
        if (uOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado!");
        }
        Livro livro = uOptional.get();
        BeanUtils.copyProperties(uOptional, livro);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(livroRepository.save(livro));
    }

    @DeleteMapping("/livros/{isbn}")
    public ResponseEntity<Object> excluiLivro(@PathVariable(name = "isbn") String isbn, @RequestBody LivroRecordDto livroRecordDto){
        Optional<Livro> uOptional = livroRepository.findById(isbn);
        if (uOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado!");
        }
        livroRepository.deleteById(isbn);
        return ResponseEntity.status(HttpStatus.OK).body("Livro excluído com sucesso!");
    }
}