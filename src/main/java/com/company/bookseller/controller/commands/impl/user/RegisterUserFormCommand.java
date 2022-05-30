package com.company.bookseller.controller.commands.impl.user;

import com.company.bookseller.controller.commands.Command;
import jakarta.servlet.http.HttpServletRequest;

public class RegisterUserFormCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {
        return "jsp/registerUserForm.jsp";
    }
}
