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

    @GetMapping("/estudantes")
    public ResponseEntity<List<Estudante>> consultaestudantesCadastrados(){
        return ResponseEntity.status(HttpStatus.OK).body(estudanteRepository.findAll());
    }

    @GetMapping("/estudantes/{matricula}")
    public ResponseEntity<Object> consultaEstudantePormatricula(@PathVariable(name = "matricula") String matricula) {
        Optional<Estudante> uOptional = estudanteRepository.findById(matricula);
        if (uOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(uOptional.get());

    }

    @PutMapping("/estudantes/{matricula}")
    public ResponseEntity<Object> alteraEstudante(@PathVariable(name = "matricula") String matricula, @RequestBody EstudanteRecordDto EstudanteRecordDto){
        Optional<Estudante> uOptional = estudanteRepository.findById(matricula);
        if (uOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usário não encontrado!");
        }
        Estudante Estudante = uOptional.get();
        BeanUtils.copyProperties(EstudanteRecordDto, Estudante);
        return ResponseEntity.status(HttpStatus.OK).body(estudanteRepository.save(Estudante));
    }

    @DeleteMapping("/estudantes/{matricula}")
    public ResponseEntity<Object> excluiEstudante(@PathVariable(name = "matricula") String matricula){
        Optional<Estudante> uOptional = estudanteRepository.findById(matricula);
        if (uOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
        estudanteRepository.deleteById(matricula);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário excluído com sucesso!");
    }
}
