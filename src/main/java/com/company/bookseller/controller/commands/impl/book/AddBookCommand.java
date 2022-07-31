package com.company.bookseller.controller.commands.impl.book;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.service.BookService;
import com.company.bookseller.service.dto.BookDto;
import com.company.bookseller.util.MessageManager;
import jakarta.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AddBookCommand implements Command {
    private final BookService bookService;

    public AddBookCommand(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        BookDto book = new BookDto();
        log.info("book create");
        book.setImage(req.getParameter("image"));
        book.setAuthor(req.getParameter("author"));
        book.setTitle(req.getParameter("title"));
        book.setCover(BookDto.Cover.valueOf(req.getParameter("cover")));
        book.setPages(Integer.parseInt(req.getParameter("pages")));
        book.setIsbn(req.getParameter("isbn"));
        book.setPrice(new BigDecimal(req.getParameter("price")));
        log.info("book parameter setting");
        BookDto createdBook = bookService.create(book);
        req.setAttribute("book", createdBook);
        log.info("Book add to database");
        req.setAttribute("message", MessageManager.getMessage("msg.addBook"));
        return "jsp/book.jsp";
    }
}
