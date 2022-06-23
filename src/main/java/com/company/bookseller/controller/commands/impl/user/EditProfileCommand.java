package com.company.bookseller.controller.commands.impl.user;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.service.UserService;
import com.company.bookseller.service.dto.UserDto;
import jakarta.servlet.http.HttpServletRequest;

public class EditProfileCommand implements Command {
    private final UserService userService;

    public EditProfileCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        String id = req.getParameter("id");
        UserDto user = userService.get(Long.valueOf(id));
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setRole(UserDto.Role.valueOf(req.getParameter("role")));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        UserDto editUser = userService.update(user);
        req.setAttribute("user", editUser);
        return "jsp/profile.jsp";
    }
}
