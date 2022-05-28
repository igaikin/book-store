package com.company.bookseller.controller.impl;

import com.company.bookseller.controller.Command;
import jakarta.servlet.http.HttpServletRequest;

public class LoginPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        return "jsp/login.jsp";
    }
}
