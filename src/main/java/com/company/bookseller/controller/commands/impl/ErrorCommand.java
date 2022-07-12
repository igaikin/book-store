package com.company.bookseller.controller.commands.impl;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.util.MessageManager;
import jakarta.servlet.http.HttpServletRequest;

public class ErrorCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {
        req.setAttribute("message", MessageManager.getMessage("msg.pageNotFound"));
        return "jsp/error.jsp";
    }
}
