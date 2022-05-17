package com.company.bookseller.controller.impl.add;

import com.company.bookseller.controller.Command;
import jakarta.servlet.http.HttpServletRequest;

public class AddBookFormCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {
        return "jsp/addBookForm.jsp";
    }
}
