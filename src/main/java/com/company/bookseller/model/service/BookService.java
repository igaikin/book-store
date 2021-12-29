package com.company.bookseller.model.service;

import com.company.bookseller.model.beans.Book;

import java.util.List;

public interface BookService {
    Book getById(long id);

    List<Book> getAll();

}
