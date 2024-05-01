package com.biblioteca.apibiblioteca.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.apibiblioteca.dto.EmprestimoRecordDto;
import com.biblioteca.apibiblioteca.model.Emprestimo;
import com.biblioteca.apibiblioteca.repository.EmprestimoRepository;

import io.micrometer.core.ipc.http.HttpSender.Response;

@RestController
public class EmprestimoController {

    @Autowired
    EmprestimoRepository emprestimoRepository;

    @PostMapping("/emprestimos")
    public ResponseEntity<Emprestimo> cadastraEmprestimo(@RequestBody EmprestimoRecordDto emprestimoRecordDto){
        Emprestimo emprestimo = new Emprestimo();
        BeanUtils.copyProperties(emprestimoRecordDto, emprestimo);
        return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoRepository.save(emprestimo));
    }
}
