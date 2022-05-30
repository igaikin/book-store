package com.company.bookseller.controller.commands.impl.book;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.service.BookService;
import com.company.bookseller.service.dto.BookDto;
import com.company.bookseller.service.impl.BookServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

public class GetBooksCommand implements Command {
    private static final BookService BOOK_SERVICE = new BookServiceImpl();

    @Override
    public String execute(HttpServletRequest req) {
        List<BookDto> books = BOOK_SERVICE.getAll();
        req.setAttribute("books", books);
        return "jsp/allBooks.jsp";
    }
}
