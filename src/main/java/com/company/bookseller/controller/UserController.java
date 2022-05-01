package com.company.bookseller.controller;

import com.company.bookseller.service.UserService;
import com.company.bookseller.service.dto.UserDto;
import com.company.bookseller.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserController extends HttpServlet {
    private static final UserService USER_SERVICE = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id == null) {
            List<UserDto> users = USER_SERVICE.getAll();
            req.setAttribute("users", users);
            req.getRequestDispatcher("allUsers.jsp").forward(req, resp);
        } else {
            UserDto user = USER_SERVICE.get(Long.valueOf(id));
            req.setAttribute("user", user);
            req.getRequestDispatcher("user.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
