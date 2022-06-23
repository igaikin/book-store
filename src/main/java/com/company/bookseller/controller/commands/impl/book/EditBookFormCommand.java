package com.company.bookseller.controller.commands.impl.book;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.service.BookService;
import com.company.bookseller.service.dto.BookDto;
import jakarta.servlet.http.HttpServletRequest;

public class EditBookFormCommand implements Command {
    private final BookService bookService;

    public EditBookFormCommand(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        String id = req.getParameter("id");
        BookDto editBook = bookService.get(Long.valueOf(id));
        req.setAttribute("id", id);
        req.setAttribute("book", editBook);
        if (editBook == null) {
            req.setAttribute("message", "Book with ID: " + id + "not found");
            return "jsp/error.jsp";
        }
        return "jsp/editBookForm.jsp";
    }
}
