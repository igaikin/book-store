package com.company.bookseller.service.impl;

import com.company.bookseller.dao.BookDao;
import com.company.bookseller.dao.entity.Book;
import com.company.bookseller.service.BookService;
import com.company.bookseller.service.dto.BookDto;
import java.util.List;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {
    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    private Book bookToEntity(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setImage(bookDto.getImage());
        book.setAuthor(bookDto.getAuthor());
        book.setTitle(bookDto.getTitle());
        book.setCover(Book.Cover.valueOf(bookDto.getCover().toString()));
        book.setPages(bookDto.getPages());
        book.setIsbn(bookDto.getIsbn());
        book.setPrice(bookDto.getPrice());
        return book;
    }

    private BookDto bookToDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setImage(book.getImage());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setTitle(book.getTitle());
        bookDto.setCover(BookDto.Cover.valueOf(book.getCover().toString()));
        bookDto.setPages(book.getPages());
        bookDto.setIsbn(book.getIsbn());
        bookDto.setPrice(book.getPrice());
        return bookDto;
    }
//
//    @Override
//    public List<BookDto> getAll() {
//        return bookDao.getAll()
//                .stream()
//                .map(this::bookToDto)
//                .collect(Collectors.toList());
//    }

    @Override
    public List<BookDto> getSearch(String search) {
        return bookDao.getSearch(search)
                .stream()
                .map(this::bookToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> getAll(int limit, int offset) {
        return bookDao.getAll(limit, offset)
                .stream()
                .map(this::bookToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookDto get(Long id) {
        Book book = bookDao.get(id);
        if (book == null) {
            throw new RuntimeException("There is no user with id: " + id);
        }
        return bookToDto(book);
    }

    @Override
    public BookDto create(BookDto bookDto) {
        Book existing = bookDao.getByIsbn(bookDto.getIsbn());
        if (existing != null) {
            throw new RuntimeException("Book with ISBN: " + bookDto.getIsbn() + " already exists");
        }
        Book created = bookDao.create(bookToEntity(bookDto));
        return get(created.getId());
    }

    @Override
    public BookDto update(BookDto bookDto) {
        Book existing = bookDao.getByIsbn(bookDto.getIsbn());
        if (existing != null && existing.getId() != bookDto.getId()) {
            throw new RuntimeException("Book with ISBN: ********** " + bookDto.getIsbn() + " ********* does not exist");
        }
        Book updated = bookDao.update(bookToEntity(bookDto));
        return get(updated.getId());
    }

    public void delete(Long id) {
        if (!bookDao.delete(id)) {
            throw new RuntimeException("Couldn't delete book [id=" + id + "]");
        }
    }
}
