package com.biblioteca.apibiblioteca.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.apibiblioteca.dto.EstudanteRecordDto;
import com.biblioteca.apibiblioteca.model.Estudante;
import com.biblioteca.apibiblioteca.repository.EstudanteRepository;


@RestController
public class EstudanteController {
    @Autowired
    EstudanteRepository estudanteRepository;

    @PostMapping("/estudantes")
    public ResponseEntity<Estudante> cadastraEstudante(@RequestBody EstudanteRecordDto estudanteRecordDto){
        Estudante estudante = new Estudante();
        BeanUtils.copyProperties(estudanteRecordDto, estudante);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudanteRepository.save(estudante));
    }
}
