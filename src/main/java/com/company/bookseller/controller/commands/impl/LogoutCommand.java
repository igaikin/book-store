package com.company.bookseller.controller.commands.impl;

import com.company.bookseller.controller.commands.Command;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LogoutCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        String page = "index.jsp";
        req.getSession().setAttribute("page", page);
        return page;
    }
}
