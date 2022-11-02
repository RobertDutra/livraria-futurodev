package com.br.livrariafuturodev.controller;

import com.br.livrariafuturodev.entity.Author;
import com.br.livrariafuturodev.entity.Book;
import com.br.livrariafuturodev.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book saveBook(@RequestBody Book book){
        return this.bookService.salvar(book);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Book> listarBooks(){
        return this.bookService.listar();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book buscarBook(@PathVariable Long id){
        return this.bookService.buscar(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book atualizarBook(@PathVariable Long id, @RequestBody Book book){
        return this.bookService.atualizar(id, book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarAuthor(@PathVariable Long id){
        this.bookService.deletar(id);}
}
