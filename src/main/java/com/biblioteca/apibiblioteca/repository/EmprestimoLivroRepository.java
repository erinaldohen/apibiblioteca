package com.biblioteca.apibiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.apibiblioteca.model.EmprestimoLivro;

@Repository
public interface EmprestimoLivroRepository extends JpaRepository<EmprestimoLivro, Integer>{

}
