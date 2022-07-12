package com.company.bookseller.controller.commands.impl.user;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.service.UserService;
import com.company.bookseller.service.dto.UserDto;
import com.company.bookseller.util.MessageManager;
import jakarta.servlet.http.HttpServletRequest;

public class EditProfileFormCommand implements Command {
    private final UserService userService;

    public EditProfileFormCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        String id = req.getParameter("id");
        UserDto editUser = userService.get(Long.valueOf(id));
        req.setAttribute("id", id);
        req.setAttribute("user", editUser);
        if (editUser == null) {
            req.setAttribute("message", MessageManager.getMessage("msg.userNotFound"));
            return "jsp/error.jsp";
        }
        return "jsp/editProfileForm.jsp";
    }
}
