package com.company.bookseller.model.dao;

import com.company.bookseller.model.entity.Book;

public interface BookDao extends AbstractDao<Book, Long> {
    Book getByIsbn(String isbn);
}
