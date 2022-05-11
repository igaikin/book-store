package com.company.bookseller.controller.impl.add;

import com.company.bookseller.controller.Command;
import com.company.bookseller.service.UserService;
import com.company.bookseller.service.dto.UserDto;
import com.company.bookseller.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterCommand implements Command {
    private static final UserService USER_SERVICE = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        UserDto registerUser = new UserDto();
        registerUser.setFirstName(req.getParameter("firstName"));
        registerUser.setLastName(req.getParameter("lastName"));
        registerUser.setRole(UserDto.Role.valueOf(req.getParameter("role")));
        registerUser.setEmail(req.getParameter("email"));
        registerUser.setPassword(req.getParameter("password"));
        USER_SERVICE.create(registerUser);
        return //FIXME;
    }
}
