package com.company.bookseller.controller;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.controller.commands.CommandFactory;
import com.company.bookseller.util.MessageManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet("/controller")
public class Controller extends HttpServlet {
    private static final Logger LOG = LogManager.getLogger(Controller.class);

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
            LOG.error(e);
            req.setAttribute("message", MessageManager.getMessage("msg.pageNotFound"));
            page = "jsp/error.jsp";
        }
        req.getRequestDispatcher(page).forward(req, resp);
    }
}
