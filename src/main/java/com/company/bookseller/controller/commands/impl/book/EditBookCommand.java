package com.company.bookseller.controller.commands.impl.book;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.service.BookService;
import com.company.bookseller.service.dto.BookDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class EditBookCommand implements Command {
    private final BookService bookService;

    public EditBookCommand(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        String id = req.getParameter("id");
        BookDto book = bookService.get(Long.valueOf(id));
        try {
                Part part = req.getPart("image");
            if (part != null) {
                String fileName = "/" + book.getTitle() + "_" + book.getAuthor() + ".jpg";
                String uploadDir = "/images";
                Path path = Path.of(uploadDir);
                if (Files.notExists(path)) {
                    Files.createDirectory(path);
                }
                part.write(path.toAbsolutePath() + fileName);
                log.info("File saved as " + uploadDir + fileName);
            }
        } catch (IOException | ServletException e) {
            throw new RuntimeException(e);
        }
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
