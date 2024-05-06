package com.biblioteca.apibiblioteca.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
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
import com.biblioteca.apibiblioteca.dto.UsuarioRecordDto;
import com.biblioteca.apibiblioteca.model.Usuario;
import com.biblioteca.apibiblioteca.repository.UsuarioRepository;

@RestController
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> cadastraUsuario(@RequestBody UsuarioRecordDto usuarioRecordDto){
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioRecordDto, usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> consultaUsuariosCadastrados(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findAll());
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Object> consultaUsuarioPorId(@PathVariable(name = "id") UUID id) {
        Optional<Usuario> uOptional = usuarioRepository.findById(id);
        if (uOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(uOptional.get());

    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Object> alteraUsuario(@PathVariable(name = "id") UUID id, @RequestBody UsuarioRecordDto usuarioRecordDto){
        Optional<Usuario> uOptional = usuarioRepository.findById(id);
        if (uOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usário não encontrado!");
        }
        Usuario usuario = uOptional.get();
        BeanUtils.copyProperties(usuarioRecordDto, usuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuario));
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Object> excluiUsuario(@PathVariable(name = "id") UUID id){
        Optional<Usuario> uOptional = usuarioRepository.findById(id);
        if (uOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
        usuarioRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário excluído com sucesso!");
    }
}