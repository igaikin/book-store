package com.company.bookseller.controller.commands.impl.book;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.controller.commands.CommandFactory;
import com.company.bookseller.service.BookService;
import com.company.bookseller.service.dto.BookDto;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DeleteBookCommand implements Command {
    private static final Logger LOG = LogManager.getLogger(DeleteBookCommand.class);
    private final BookService bookService;

    public DeleteBookCommand(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        String id = req.getParameter("id");
        BookDto book = bookService.get(Long.valueOf(id));
        if (book == null) {
            req.setAttribute("message", "Book with ID: " + id + "not found");
            return "jsp/error.jsp";
        }
        bookService.delete(Long.valueOf(id));
        LOG.info("Book deleted");
        CommandFactory.getInstance().getCommand("books").execute(req);
        return "jsp/allBooks.jsp";
    }
}
