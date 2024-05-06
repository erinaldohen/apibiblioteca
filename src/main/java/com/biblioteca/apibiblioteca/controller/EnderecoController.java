package com.biblioteca.apibiblioteca.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.apibiblioteca.dto.EnderecoRecordDto;
import com.biblioteca.apibiblioteca.model.Endereco;
import com.biblioteca.apibiblioteca.repository.EnderecoRepository;

@RestController
@CrossOrigin("*")
public class EnderecoController {
    @Autowired
    EnderecoRepository enderecoRepository;
    @PostMapping("/enderecos")
    public ResponseEntity<Endereco> cadastraEndereco(@RequestBody EnderecoRecordDto enderecoRecordDto){
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoRecordDto, endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoRepository.save(endereco));
    }
}
