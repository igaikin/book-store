package com.company.bookseller.controller.impl.user;

import com.company.bookseller.controller.Command;
import com.company.bookseller.service.UserService;
import com.company.bookseller.service.dto.UserDto;
import com.company.bookseller.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class EditProfileFormCommand implements Command {

    private static final UserService USER_SERVICE = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest req) {
        String id = req.getParameter("id");
        UserDto editUser = USER_SERVICE.get(Long.valueOf(id));
        req.setAttribute("id", id);
        req.setAttribute("user", editUser);
        if (editUser == null) {
            req.setAttribute("message", "User with ID: " + id + "not found");
            return "jsp/error.jsp";
        }
        return "jsp/editProfileForm.jsp";
    }
}
