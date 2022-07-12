package com.company.bookseller.controller.commands.impl.book;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.service.BookService;
import com.company.bookseller.service.dto.BookDto;
import com.company.bookseller.util.MessageManager;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetBookCommand implements Command {
    private static final Logger LOG = LogManager.getLogger(GetBookCommand.class);
    private final BookService bookService;

    public GetBookCommand(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        String id = req.getParameter("id");
        BookDto book = bookService.get(Long.valueOf(id));
        if (book == null) {
            req.setAttribute("message", MessageManager.getMessage("msg.bookNotFound"));
            return "jsp/error.jsp";
        }
        req.setAttribute("book", book);
        return "jsp/book.jsp";
    }
}
