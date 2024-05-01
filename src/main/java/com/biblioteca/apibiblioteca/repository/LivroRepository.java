package com.biblioteca.apibiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.biblioteca.apibiblioteca.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro,String>{

}