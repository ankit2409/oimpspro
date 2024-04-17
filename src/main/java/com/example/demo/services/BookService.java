package com.example.demo.services;

import com.example.demo.model.Book;

import java.util.Collection;

public interface BookService {

        Collection<Book> getBooks();
        Book addBook(Book book);

}
