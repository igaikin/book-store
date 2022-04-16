package com.company.bookseller.model.service.impl;

import com.company.bookseller.model.dao.BookDao;
import com.company.bookseller.model.dao.impl.BookDaoJdbcImpl;
import com.company.bookseller.model.dto.BookDto;
import com.company.bookseller.model.entity.Book;
import com.company.bookseller.model.service.BookService;

import java.util.List;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {
    private final BookDao bookDao = new BookDaoJdbcImpl();

    private Book bookToEntity(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setAuthor(bookDto.getAuthor());
        book.setTitle(bookDto.getTitle());
        book.setCover(Book.Cover.valueOf(bookDto.getCover().toString()));
        book.setNumberOfPages(bookDto.getNumberOfPages());
        book.setIsbn(bookDto.getIsbn());
        book.setPrice(bookDto.getPrice());
        return book;
    }

    private BookDto bookToDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setTitle(book.getTitle());
        bookDto.setCover(BookDto.Cover.valueOf(book.getCover().toString()));
        bookDto.setNumberOfPages(book.getNumberOfPages());
        bookDto.setIsbn(book.getIsbn());
        bookDto.setPrice(book.getPrice());
        return bookDto;
    }

    @Override
    public List<BookDto> getAll() {
        return bookDao.getAll().stream()
                .map(this::bookToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookDto get(Long id) {
        return bookToDto(bookDao.get(id));
    }

    @Override
    public BookDto create(BookDto bookDto) {
        return get(bookToEntity(bookDto).getId());
    }

    public Book create(Book book) {
        Book existing = bookDao.getByIsbn(book.getIsbn());
        if (existing != null) {
            throw new RuntimeException("Book with ISBN: " + book.getIsbn() + " already exists");
        }
        return bookDao.create(book);
    }

    public BookDto update(BookDto bookDto) {
        Book existing = bookDao.getByIsbn(bookDto.getIsbn());
        if (existing == null) {
            throw new RuntimeException("Book with ISBN: ********** " + bookDto.getIsbn() + " ********* does not exist");
        }
        return bookDao.update(bookDto);
    }

    public boolean delete(Long id) {
        return bookDao.delete(id);
    }
}
