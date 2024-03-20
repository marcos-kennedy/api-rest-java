package com.projetos.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetos.api.models.Pessoa;
import com.projetos.api.repositorys.PessoasRepository;
import com.projetos.api.services.Servico;

@RestController
public class PessoasController {
    @Autowired
    private PessoasRepository pessoasRepository;
    @Autowired
    private Servico servico;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarPessoa(@RequestBody Pessoa pessoa){
        return servico.cadastrar(pessoa);
    }
    @GetMapping("/listar")
    public ResponseEntity<?> listarPessoas(){
        return servico.listar();
    }
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> buscarPessoa(@PathVariable int id){
        return servico.listarId(id);
    }
    @PutMapping("/alterar")
    public ResponseEntity<?> alterarDados(@RequestBody Pessoa pessoa){
        return servico.alterar(pessoa);
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarPessoa(@PathVariable int id){
        return servico.deletar(id);
    }
    @GetMapping("/contador")
    public String contador(){
        long quantidade = pessoasRepository.count();
        return quantidade + " pessoas registradas";
    }
    @GetMapping("/ordenarNome")
    public List<Pessoa> ordenarNome(){
        return pessoasRepository.findByOrderByNome();
    }
    @GetMapping("/buscarPorTermo/{termo}")
    public List<Pessoa> buscarTermo(@PathVariable String termo){
        return pessoasRepository.findByNomeContaining(termo);
    }
}
