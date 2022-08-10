package com.company.bookseller.controller.commands.impl;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.service.BookService;
import com.company.bookseller.service.dto.BookDto;
import com.company.bookseller.service.util.paging.Paging;
import com.company.bookseller.service.util.paging.PagingUtil;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

public class SearchCommand implements Command {
    private static final String EMPTY_STRING = "";
    private final BookService bookService;

    public SearchCommand(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        Paging paging = PagingUtil.extractPaging(req);
        String search = req.getParameter("searchString");
        List<BookDto> books = bookService.search(search == null ? EMPTY_STRING : search, paging.getLimit(), paging.getOffset());
        req.setAttribute("currentPage", PagingUtil.getCurrentPage(paging));
        req.setAttribute("lastPage", PagingUtil.getTotalPages(bookService.count(), paging.getLimit()));
        req.setAttribute("books", books);
        req.setAttribute("searchString", search);
        return "jsp/allBooks.jsp"; //FIXME Pagination
    }

}
