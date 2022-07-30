package com.company.bookseller.controller.commands.impl;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.service.BookService;
import com.company.bookseller.service.dto.BookDto;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

public class SearchCommand implements Command {
    private static final String REGEX = "";
    private final BookService bookService;

    public SearchCommand(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        String search = req.getParameter("search");
        List<BookDto> books = bookService.getSearch(search == null ? REGEX : search);
        req.setAttribute("books", books);
        return "jsp/allBooks.jsp";
    }
}
