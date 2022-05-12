package com.company.bookseller.controller.impl.get;

import com.company.bookseller.controller.Command;
import com.company.bookseller.service.UserService;
import com.company.bookseller.service.dto.UserDto;
import com.company.bookseller.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetProfileCommand implements Command {
    private static final UserService USER_SERVICE = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        UserDto user = USER_SERVICE.get(Long.valueOf(id));
        if (user == null) {
            req.setAttribute("message", "User with ID: " + id + "not found");
            return "jsp/error.jsp";
        }
        req.setAttribute("user", user);
        return "jsp/profile.jsp";
    }
}
