package com.company.bookseller.controller.commands.impl;

import com.company.bookseller.controller.commands.Command;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LogoutCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if ((session != null) && session.getAttribute("userGlobal") != null) {
//            session.removeAttribute("userGlobal");
//            req.getSession(false).removeAttribute("userGlobal");
            session.invalidate();
        }
        return "index.jsp";
    }
}
