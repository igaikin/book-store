package com.company.bookseller.model.service.impl;

import com.company.bookseller.model.beans.Book;
import com.company.bookseller.model.dao.BookDao;
import com.company.bookseller.model.dao.impl.BookDaoJdbcImpl;
import com.company.bookseller.model.service.BookService;
import com.company.bookseller.model.service.OrderService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookDao bookDao = new BookDaoJdbcImpl();
    private final OrderService orderService = new OrderServiceImpl();

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }

    @Override
    public Book get(Long id) {
        Book book = bookDao.get(id);
        return book;
    }

    public Book create(Book book) {
        Book existing = bookDao.getByIsbn(book.getIsbn());
        if (existing != null) {
            throw new RuntimeException("Book with ISBN: " + book.getIsbn() + " already exists");
        }
        return bookDao.create(book);
    }

    public Book update(Book book) {
        Book existing = bookDao.getByIsbn(book.getIsbn());
        assert existing != null;
        if (book.getId() != existing.getId()) {
            throw new RuntimeException("Book with ISBN: ********** " + book.getIsbn() + " ********* does not exist");
        }
        return bookDao.update(book);
    }

    public boolean delete(Long id) {
        return bookDao.delete(id);
    }
}
