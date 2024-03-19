package com.projetos.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetos.api.models.Pessoa;

public interface PessoasRepository extends JpaRepository<Pessoa, Integer> {
    List<Pessoa> findAll();
    Pessoa findById(int id);
    List<Pessoa> findByOrderByNome();
    List<Pessoa> findByNomeContaining(String termo);
}
