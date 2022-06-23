package com.company.bookseller.controller.commands.impl;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.service.UserService;
import com.company.bookseller.service.dto.UserDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginCommand implements Command {
    public static final Logger LOG = LogManager.getLogger(LoginCommand.class);
    private final UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try {
            if (userService.login(email, password)) {
                UserDto user = userService.getByEmail(email);
                HttpSession session = req.getSession();
                session.setAttribute("userGlobal", user);
                return "index.jsp";
            }
        } catch (Exception e) {
            LOG.error(e);
        }
        LOG.info("Invalid login attempt, email{}, password{}", email, password);
        req.setAttribute("message", "Invalid credentials, please try again");
        return "jsp/login.jsp";
    }
}
