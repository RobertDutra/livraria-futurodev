package com.br.livrariafuturodev.controller;

import com.br.livrariafuturodev.entity.Author;
import com.br.livrariafuturodev.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livraria")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author cadastrarAuthor(@RequestBody Author author){
        return this.authorService.salvar(author);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Author> listarAuthores(){
        return this.authorService.listar();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author buscarAuthor(@PathVariable Long id){
        return this.authorService.buscar(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author atualizarAuthor(@PathVariable Long id, @RequestBody Author author){
        return this.authorService.atualizar(id, author);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarAuthor(@PathVariable Long id){
        this.authorService.deletar(id);
    }

}
