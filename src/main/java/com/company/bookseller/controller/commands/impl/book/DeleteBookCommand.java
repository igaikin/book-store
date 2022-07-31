package com.company.bookseller.controller.commands.impl.book;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.controller.commands.CommandFactory;
import com.company.bookseller.service.BookService;
import com.company.bookseller.service.dto.BookDto;
import com.company.bookseller.util.MessageManager;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class DeleteBookCommand implements Command {
    private final BookService bookService;

    public DeleteBookCommand(BookService bookService) {
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
        bookService.delete(Long.valueOf(id));
        log.info("Book deleted");
        CommandFactory.getInstance().getCommand("books").execute(req);
        return "jsp/allBooks.jsp";
    }
}
