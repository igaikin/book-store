package com.company.bookseller.dao;

import com.company.bookseller.dao.entity.Book;

public interface BookDao extends AbstractDao<Book, Long> {
    Book getByIsbn(String isbn);
}
