package com.company.bookseller.controller.commands.impl.book;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.controller.commands.CommandFactory;
import com.company.bookseller.service.BookService;
import com.company.bookseller.service.dto.BookDto;
import com.company.bookseller.service.impl.BookServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeleteBookCommand implements Command {
    private static final Logger LOG = LogManager.getLogger(DeleteBookCommand.class);
    private static final BookService BOOK_SERVICE = new BookServiceImpl();

    @Override
    public String execute(HttpServletRequest req) {
        String id = req.getParameter("id");
        BookDto book = BOOK_SERVICE.get(Long.valueOf(id));
        if (book == null) {
            req.setAttribute("message", "Book with ID: " + id + "not found");
            return "jsp/error.jsp";
        }
        BOOK_SERVICE.delete(Long.valueOf(id));
        LOG.info("Book deleted");
        CommandFactory.getInstance().getCommand("books").execute(req);
        return "jsp/allBooks.jsp";
    }
}
