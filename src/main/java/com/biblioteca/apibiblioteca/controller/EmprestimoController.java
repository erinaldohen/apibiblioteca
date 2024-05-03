package com.biblioteca.apibiblioteca.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.apibiblioteca.dto.EmprestimoRecordDto;
import com.biblioteca.apibiblioteca.model.Emprestimo;
import com.biblioteca.apibiblioteca.repository.EmprestimoRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



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

    @GetMapping("/emprestimos")
    public ResponseEntity<List<Emprestimo>> consultaEmprestimo(){
        return ResponseEntity.status(HttpStatus.OK).body(emprestimoRepository.findAll());
    }

    @GetMapping("/emprestimos/{id}")
    public ResponseEntity<Object> consultaEmprestimoPorId(@PathVariable(name = "id") UUID id){
        Optional<Emprestimo> uOptional = emprestimoRepository.findById(id);
        if (uOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empréstimo não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(uOptional.get());
    }

    @PutMapping("/emprestimos/{id}")
    public ResponseEntity<Object> alteraEmprestimo(@PathVariable(name = "id") UUID id, @RequestBody EmprestimoRecordDto emprestimoRecordDto){
        Optional<Emprestimo> uOptional = emprestimoRepository.findById(id);
        if (uOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usário não encontrado!");
        }
        Emprestimo emprestimo = uOptional.get();
        BeanUtils.copyProperties(emprestimoRecordDto, emprestimo);
        return ResponseEntity.status(HttpStatus.OK).body(emprestimoRepository.save(emprestimo));
    }

    @DeleteMapping("/emprestimos/{id}")
    public ResponseEntity<Object> excluirEmprestimo(@PathVariable(name = "id") UUID id){
        Optional<Emprestimo> uOptional = emprestimoRepository.findById(id);
        if (uOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empre´stimo não encontrado!");
        }
        emprestimoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Empréstimo excluído com sucesso!");
    }
}  