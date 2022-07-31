package com.company.bookseller.controller.commands.impl;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.service.UserService;
import com.company.bookseller.service.dto.UserDto;
import com.company.bookseller.util.MessageManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class LoginCommand implements Command {
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
            log.error(e);
        }
        log.info("Invalid login attempt, email{}, password{}", email, password);
        req.setAttribute("message", MessageManager.getMessage("msg.invalidCredential"));
        return "jsp/login.jsp";
    }
}
