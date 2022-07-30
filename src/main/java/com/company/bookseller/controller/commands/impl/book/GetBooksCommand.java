package com.company.bookseller.controller.commands.impl.book;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.service.BookService;
import com.company.bookseller.service.dto.BookDto;
import com.company.bookseller.service.util.paging.Paging;
import com.company.bookseller.service.util.paging.PagingUtil;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetBooksCommand implements Command {
    private static final Logger LOG = LogManager.getLogger(GetBooksCommand.class);
    private final BookService bookService;

    public GetBooksCommand(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        Paging paging = PagingUtil.extractPaging(req);
        List<BookDto> books = bookService.getAll(paging.getLimit(), paging.getOffset());

        req.setAttribute("books", books);
        return "jsp/allBooks.jsp";
    }
}
