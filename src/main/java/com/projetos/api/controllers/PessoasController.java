package com.projetos.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetos.api.models.Pessoa;
import com.projetos.api.repository.PessoasRepository;

@RestController
public class PessoasController {
    @Autowired
    private PessoasRepository pessoasRepository;
    
    @PostMapping("/cadastrar")
    public Pessoa cadastrar(@RequestBody Pessoa pessoa){
        return pessoasRepository.save(pessoa);
    }
    @GetMapping("/listar")
    public List<Pessoa> listarPessoas(){
        return pessoasRepository.findAll();
    }
    @GetMapping("/listar/{id}")
    public Pessoa buscarPessoa(@PathVariable int id){
        return pessoasRepository.findById(id);
    }
    @GetMapping("")
    public String mensagem(){
        return "Hello Word";
    }
    @GetMapping("/home")
    public String boasVindas(){
        return "Seja Bem Vindo(a)";
    }
    @GetMapping("/home/{nome}")
    public String boasVindas(@PathVariable String nome){
        return "Seja Bem Vindo(a) " + nome;
    }
    @PostMapping("/pessoa")
    public Pessoa getPessoa(@RequestBody Pessoa pessoa){
        return pessoa;
    }
}
