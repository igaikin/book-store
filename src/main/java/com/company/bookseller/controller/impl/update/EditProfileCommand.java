package com.company.bookseller.controller.impl.update;

import com.company.bookseller.controller.Command;
import com.company.bookseller.service.UserService;
import com.company.bookseller.service.dto.UserDto;
import com.company.bookseller.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class EditProfileCommand implements Command {
    private static final UserService USER_SERVICE = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest req) {
        String id = req.getParameter("id");
        UserDto user = USER_SERVICE.get(Long.valueOf(id));
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setRole(UserDto.Role.valueOf(req.getParameter("role")));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        UserDto editUser = USER_SERVICE.update(user);
        req.setAttribute("user", editUser);
        return "jsp/profile.jsp";
    }
}
