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
        UserDto user = new UserDto();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setRole(UserDto.Role.valueOf(req.getParameter("role")));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        UserDto registerUser = USER_SERVICE.create(user);
        req.setAttribute("user", registerUser);
        return "jsp/profile.jsp";
    }
}
