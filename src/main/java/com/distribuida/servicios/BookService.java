package com.distribuida.servicios;

import com.distribuida.db.Book;

import java.util.List;

public interface BookService {
    Book findById(Integer Id);
    List<Book> findAll();
    //añadir un nuevo libro
    void addBook(Book book);
    //buscar libro por id
    void updateBook(Book book, Integer id);
    //eliminar libro por id
    void deleteBook(Integer id);

}
