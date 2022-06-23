package com.company.bookseller.controller.commands.impl.user;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.service.UserService;
import com.company.bookseller.service.dto.UserDto;
import jakarta.servlet.http.HttpServletRequest;

public class RegisterCommand implements Command {
    private final UserService userService;

    public RegisterCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        UserDto user = new UserDto();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setRole(UserDto.Role.valueOf(req.getParameter("role")));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        UserDto registerUser = userService.create(user);
        req.setAttribute("user", registerUser);
        return "jsp/profile.jsp";
    }
}
