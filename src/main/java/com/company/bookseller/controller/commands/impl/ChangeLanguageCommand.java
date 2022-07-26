package com.company.bookseller.controller.commands.impl;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.util.MessageManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ChangeLanguageCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        String lang = req.getParameter( "lang");
        HttpSession session = req.getSession();
        session.setAttribute("language", lang);
        MessageManager.setLocale(lang);
        return "index.jsp";
    }

//    private Map<String, Locale> lang;
//
//    private void Language() {
//        lang = new HashMap<>();
//        lang.put("EN", Locale.ENGLISH);
//        lang.put("DE", Locale.GERMAN);
//        lang.put("RU", new Locale("ru", "RU"));
//    }
//
//    public Locale getLanguage(String language) {
//        if (language != null) {
//            return lang.get(language);
//        }
//        return lang.getOrDefault("EN", Locale.ENGLISH);
//    }
//

}
