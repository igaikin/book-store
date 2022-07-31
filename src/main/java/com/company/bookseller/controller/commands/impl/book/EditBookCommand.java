package com.company.bookseller.controller.commands.impl.book;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.service.BookService;
import com.company.bookseller.service.dto.BookDto;
import jakarta.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public class EditBookCommand implements Command {
    private final BookService bookService;

    public EditBookCommand(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        String id = req.getParameter("id");
        BookDto book = bookService.get(Long.valueOf(id));
        book.setImage(req.getParameter("image"));
        book.setAuthor(req.getParameter("author"));
        book.setTitle(req.getParameter("title"));
        book.setCover(BookDto.Cover.valueOf(req.getParameter("cover")));
        book.setPages(Integer.parseInt(req.getParameter("pages")));
        book.setIsbn(req.getParameter("isbn"));
        book.setPrice(new BigDecimal(req.getParameter("price")));
        BookDto editBook = bookService.update(book);
        req.setAttribute("book", editBook);
        return "jsp/book.jsp";
    }
}
