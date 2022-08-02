package com.company.bookseller.dao;

import com.company.bookseller.dao.entity.Book;
import java.util.List;

public interface BookDao extends AbstractDao<Book, Long> {
    Book getByIsbn(String isbn);

    List<Book> search(String search, int limit, int offset);
}
