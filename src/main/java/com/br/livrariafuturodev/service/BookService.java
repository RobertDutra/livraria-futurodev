package com.br.livrariafuturodev.service;

import com.br.livrariafuturodev.entity.Author;
import com.br.livrariafuturodev.entity.Book;
import com.br.livrariafuturodev.repository.BookRepository;
import com.br.livrariafuturodev.service.interfaces.BookInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements BookInterface {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book salvar(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public Book atualizar(Long id, Book book) {
        Optional<Book> bookPesquisado = this.bookRepository.findById(id);
        if (bookPesquisado.isPresent()){
            BeanUtils.copyProperties(book, bookPesquisado.get(), "id");
            return this.salvar(bookPesquisado.get());
        }
        return null;
    }

    @Override
    public Book buscar(Long id) {
        return this.bookRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("Book com id " +  id + " nao encontrado");});
    }

    @Override
    public List<Book> listar() {
        return this.bookRepository.findAll();
    }

    @Override
    public void deletar(Long id) {
        Book book = this.buscar(id);
        this.bookRepository.delete(book);
    }
}
