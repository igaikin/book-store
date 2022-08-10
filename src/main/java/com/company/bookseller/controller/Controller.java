package com.company.bookseller.controller;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.controller.commands.CommandFactory;
import com.company.bookseller.util.MessageManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet("/controller")
@MultipartConfig(fileSizeThreshold = Controller.MB,
        maxFileSize = Controller.MB * 10,
        maxRequestSize = Controller.MB * 100)
public class Controller extends HttpServlet {
    public static final int MB = 1024 * 1024;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("command");
        Command command = CommandFactory.getInstance().getCommand(action.toUpperCase());
        String page;
        try {
            page = command.execute(req);
        } catch (Exception e) {
            log.error(e);
            req.setAttribute("message", MessageManager.getMessage("msg.pageNotFound"));
            page = "jsp/error.jsp";
        }
        req.getRequestDispatcher(page).forward(req, resp);
    }
}
