package com.company.bookseller.controller.impl.update;

import com.company.bookseller.controller.Command;
import com.company.bookseller.service.BookService;
import com.company.bookseller.service.dto.BookDto;
import com.company.bookseller.service.impl.BookServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class EditBookFormCommand implements Command {

    private static final BookService BOOK_SERVICE = new BookServiceImpl();

    @Override
    public String execute(HttpServletRequest req) {
        String id = req.getParameter("id");
        BookDto editBook = BOOK_SERVICE.get(Long.valueOf(id));
        req.setAttribute("id", id);
        req.setAttribute("book", editBook);
        if (editBook == null) {
            req.setAttribute("message", "Book with ID: " + id + "not found");
            return "jsp/error.jsp";
        }
        return "jsp/editBookForm.jsp";
    }
}
