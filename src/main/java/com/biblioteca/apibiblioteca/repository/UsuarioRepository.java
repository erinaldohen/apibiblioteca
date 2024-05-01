package com.biblioteca.apibiblioteca.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.biblioteca.apibiblioteca.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,UUID> {

}
