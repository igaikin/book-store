package com.company.bookseller.controller.impl.add;

import com.company.bookseller.controller.Command;
import com.company.bookseller.service.BookService;
import com.company.bookseller.service.dto.BookDto;
import com.company.bookseller.service.impl.BookServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public class AddBookCommand implements Command {
    private static final BookService BOOK_SERVICE = new BookServiceImpl();

    @Override
    public String execute(HttpServletRequest req) {
        BookDto book = new BookDto();
        book.setAuthor(req.getParameter("author"));
        book.setTitle(req.getParameter("title"));
        book.setCover(BookDto.Cover.valueOf(req.getParameter("cover")));
        book.setPages(Integer.parseInt(req.getParameter("pages")));
        book.setIsbn(req.getParameter("isbn"));
        book.setPrice(new BigDecimal(req.getParameter("price")));
        BookDto createdBook = BOOK_SERVICE.create(book);
        req.setAttribute("book", createdBook);
        return "jsp/book.jsp";
    }
}
