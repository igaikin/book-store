package com.company.bookseller.controller.impl.book;

import com.company.bookseller.controller.Command;
import com.company.bookseller.service.BookService;
import com.company.bookseller.service.dto.BookDto;
import com.company.bookseller.service.impl.BookServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class GetBookCommand implements Command {
    private static final BookService BOOK_SERVICE = new BookServiceImpl();

    @Override
    public String execute(HttpServletRequest req) {
        String id = req.getParameter("id");
        BookDto book = BOOK_SERVICE.get(Long.valueOf(id));
        if (book == null) {
            req.setAttribute("message", "Book with ID: " + id + "not found");
            return "jsp/error.jsp";
        }
        req.setAttribute("book", book);
        return "jsp/book.jsp";
    }
}
