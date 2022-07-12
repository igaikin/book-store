package com.company.bookseller.controller.commands.impl;

import com.company.bookseller.controller.commands.Command;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ChangeLanguageCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.getAttribute(String.valueOf(Locale.getDefault()));
        //FIXME


        return req.getParameter("");
    }

    private Map<String, Locale> lang;

    private void Language() {
        lang = new HashMap<>();
        lang.put("EN", Locale.ENGLISH);
        lang.put("DE", Locale.GERMAN);
        lang.put("RU", new Locale("ru", "RU"));
    }

    public Locale getLanguage(String language) {
        if (language != null) {
            return lang.get(language);
        }
        return lang.getOrDefault("EN", Locale.ENGLISH);
    }


}
