package com.company.bookseller.controller.impl;

import com.company.bookseller.controller.Command;
import jakarta.servlet.http.HttpServletRequest;

public class ErrorCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {
        req.setAttribute("error", Throwable.class);
        return "jsp/error.jsp";
    }
}
