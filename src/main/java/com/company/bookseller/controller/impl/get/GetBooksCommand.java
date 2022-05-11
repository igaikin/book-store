package com.company.bookseller.controller.impl.get;

import com.company.bookseller.controller.Command;
import com.company.bookseller.service.BookService;
import com.company.bookseller.service.dto.BookDto;
import com.company.bookseller.service.impl.BookServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

public class GetBooksCommand implements Command {
    private static final BookService BOOK_SERVICE = new BookServiceImpl();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        List<BookDto> books = BOOK_SERVICE.getAll();
        req.setAttribute("books", books);
        return "jsp/allBooks.jsp";
    }
}
