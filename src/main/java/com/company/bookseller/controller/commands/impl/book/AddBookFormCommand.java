package com.company.bookseller.controller.commands.impl.book;

import com.company.bookseller.controller.commands.Command;
import jakarta.servlet.http.HttpServletRequest;

public class AddBookFormCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {
        return "jsp/addBookForm.jsp";
    }
}
