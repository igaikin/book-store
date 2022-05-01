package com.company.bookseller.controller;

import com.company.bookseller.service.BookService;
import com.company.bookseller.service.dto.BookDto;
import com.company.bookseller.service.impl.BookServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/books")
public class BookController extends HttpServlet {
    private static final BookService BOOK_SERVICE = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id == null) {
            List<BookDto> books = BOOK_SERVICE.getAll();
            req.setAttribute("books", books);
            req.getRequestDispatcher("allBooks.jsp").forward(req, resp);
        } else {
            BookDto book = BOOK_SERVICE.get(Long.valueOf(id));
            req.setAttribute("book", book);
            req.getRequestDispatcher("book.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
