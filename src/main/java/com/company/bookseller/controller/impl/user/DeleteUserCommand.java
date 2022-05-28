package com.company.bookseller.controller.impl.user;

import com.company.bookseller.controller.Command;
import com.company.bookseller.controller.CommandFactory;
import com.company.bookseller.service.UserService;
import com.company.bookseller.service.dto.UserDto;
import com.company.bookseller.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class DeleteUserCommand implements Command {
    private static final UserService USER_SERVICE = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest req) {
        String id = req.getParameter("id");
        UserDto user = USER_SERVICE.get(Long.valueOf(id));
        if (user == null) {
            req.setAttribute("message", "User with ID: " + id + "not found");
            return "jsp/error.jsp";
        }
        USER_SERVICE.delete(Long.valueOf(id));
        CommandFactory.getInstance().getCommand("users").execute(req);
        return "jsp/allUsers.jsp";
    }
}

