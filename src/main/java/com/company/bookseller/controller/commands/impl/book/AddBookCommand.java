package com.company.bookseller.controller.commands.impl.book;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.service.BookService;
import com.company.bookseller.service.dto.BookDto;
import com.company.bookseller.service.impl.BookServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddBookCommand implements Command {
    private static final Logger LOG = LogManager.getLogger(AddBookCommand.class);
    private static final BookService BOOK_SERVICE = new BookServiceImpl();

    @Override
    public String execute(HttpServletRequest req) {
        BookDto book = new BookDto();
        LOG.info("book create");
        book.setAuthor(req.getParameter("author"));
        book.setTitle(req.getParameter("title"));
        book.setCover(BookDto.Cover.valueOf(req.getParameter("cover")));
        book.setPages(Integer.parseInt(req.getParameter("pages")));
        book.setIsbn(req.getParameter("isbn"));
        book.setPrice(new BigDecimal(req.getParameter("price")));
        LOG.info("book parameter setting");
        BookDto createdBook = BOOK_SERVICE.create(book);
        req.setAttribute("book", createdBook);
        LOG.info("Book add to database");
        return "jsp/book.jsp";
    }
}
