package com.company.bookseller.controller.impl.add;

import com.company.bookseller.controller.Command;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddBookFormCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "jsp/addBookForm.jsp";
    }
}
