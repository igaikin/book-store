package com.company.bookseller.controller.commands;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Command {
    String execute(HttpServletRequest req);
}
