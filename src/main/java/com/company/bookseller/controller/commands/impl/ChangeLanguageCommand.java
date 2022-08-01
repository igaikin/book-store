package com.company.bookseller.controller.commands.impl;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.util.MessageManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class ChangeLanguageCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        String lang = req.getParameter("lang");
        HttpSession session = req.getSession();
        session.setAttribute("language", lang);
        MessageManager.setLocale(lang);
        return "index.jsp";
    }
}
