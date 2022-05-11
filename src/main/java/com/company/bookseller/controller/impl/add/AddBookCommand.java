package com.company.bookseller.controller.impl.add;

import com.company.bookseller.controller.Command;
import com.company.bookseller.service.BookService;
import com.company.bookseller.service.dto.BookDto;
import com.company.bookseller.service.impl.BookServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

public class AddBookCommand implements Command {
    private BookService BOOK_SERVICE = new BookServiceImpl();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        BookDto book = new BookDto();
book.setAuthor(req.getParameter("author");
book.setTitle(req.getParameter("title"));
book.setCover(BookDto.Cover.valueOf(req.getParameter("cover")));
book.setIsbn(req.getParameter("isbn"));
book.setPrice(BigDecimal.valueOf(req.getParameter("price")));//FIXME
BOOK_SERVICE.create(book);
        return;
    }
}

