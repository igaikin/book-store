package com.company.bookseller.controller.impl.get;

import com.company.bookseller.controller.Command;
import com.company.bookseller.service.UserService;
import com.company.bookseller.service.dto.UserDto;
import com.company.bookseller.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

public class GetUsersCommand implements Command {
    private static final UserService USER_SERVICE = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        List<UserDto> users = USER_SERVICE.getAll();
        req.setAttribute("users", users);
        return "jsp/allUsers.jsp";
    }
}
