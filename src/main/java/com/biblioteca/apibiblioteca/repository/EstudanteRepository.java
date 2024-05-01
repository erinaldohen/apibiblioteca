package com.biblioteca.apibiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.biblioteca.apibiblioteca.model.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante,String> {

}
