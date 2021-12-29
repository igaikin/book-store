package com.company.bookseller.model.dao;

import com.company.bookseller.model.beans.entities.Book;

import java.util.List;

public interface BookDao {
    List<Book> getAll();

    List<Book> getPreviewBooks();

    Book getById(long id);

    List<Book> getByOrderId(long groupId);
}
