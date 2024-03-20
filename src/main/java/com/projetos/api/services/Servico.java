package com.projetos.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projetos.api.models.Mensagem;
import com.projetos.api.models.Pessoa;
import com.projetos.api.repositorys.PessoasRepository;

@Service
public class Servico {
    @Autowired
    private Mensagem mensagem;
    @Autowired
    private PessoasRepository pessoasRepository;

    public ResponseEntity<?> cadastrar(Pessoa pessoa){
        if (pessoa.getNome().isEmpty()) {
            mensagem.setMensagem("campo nome está vazio");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (pessoa.getIdade() <= 0) {
            mensagem.setMensagem("idade inválida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(pessoasRepository.save(pessoa), HttpStatus.CREATED);
        }
    }
}