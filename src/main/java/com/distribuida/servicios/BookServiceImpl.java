package com.distribuida.servicios;

import com.distribuida.config.DbConfig;
import com.distribuida.db.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jdbi.v3.core.Handle;

import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class BookServiceImpl implements BookService {

    //Listar todos los libros
        @Inject
        private DbConfig dbConfig;
    public Book findById(Integer id){
        Handle handle = dbConfig.test().open();
        return handle.createQuery("SELECT * FROM books WHERE id = :id")
                .bind("id",id)
                .mapToBean(Book.class)
                .findOnly();
    }

    public List<Book> findAll(){
        Handle handle = dbConfig.test().open();
        return handle.createQuery("SELECT * FROM books")
                .mapToBean(Book.class)
                .list();
    }

    public void deleteBook(Integer id) {
        Handle handle = dbConfig.test().open();
         handle.createUpdate("DELETE FROM books WHERE id = :id")
                .bind("id",id).execute();
    }

    public void updateBook(Book book,Integer id) {
        Handle handle = dbConfig.test().open();
         handle.createUpdate("UPDATE books SET isbn = :isbn,title = :title, author = :author,price = :price WHERE id = :id")
                .bindBean(book)
                .bind("id",id)
                .executeAndReturnGeneratedKeys()
                .mapToBean(Book.class)
                .findOnly();
    }

    public void addBook(Book book) {
        Handle handle = dbConfig.test().open();
         handle.createUpdate("INSERT INTO books (isbn,title,author,price) Values (:isbn,:title,:author,:price)")
                .bindBean(book)
                .executeAndReturnGeneratedKeys()
                .mapToBean(Book.class)
                .findOnly();
    }
}
