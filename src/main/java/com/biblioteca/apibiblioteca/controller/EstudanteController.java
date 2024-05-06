package com.biblioteca.apibiblioteca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin("*")
public class EstudanteController {
    @Autowired
    EstudanteRepository estudanteRepository;
    //@Autowired
    //PasswordEncoder passwordEncoder;

    @PostMapping("/estudantes")
    public ResponseEntity<Estudante> cadastraEstudante(@RequestBody EstudanteRecordDto estudanteRecordDto){
        Estudante estudante = new Estudante();
        //estudanteRecordDto.senha(passwordEncoder.encode(estudanteRecordDto.senha()));
        //    passwordEncoder.encode(estudante.getSenha()));
        BeanUtils.copyProperties(estudanteRecordDto, estudante);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudanteRepository.save(estudante));
    }

//    @GetMapping("/validarSenha")
  //  public ResponseEntity<Boolean> validarSenha(@RequestParam String login,
    //                                            @RequestParam String password) {

      //  Optional<Estudante> eOptional = estudanteRepository.findById(login);
        //if (eOptional.isEmpty()) {
          //  return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login invalido!");
//        }

   //     Estudante estudante = eOptional.get();
     //   boolean valid = passwordEncoder.matches(password, estudante.getSenha());

       // HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
       // return ResponseEntity.status(status).body(valid);

    //}

    
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
