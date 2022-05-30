package com.company.bookseller.controller.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebFilter("/controller")
public class AuthorizationFilter implements Filter {
    private static final Logger LOG = LogManager.getLogger(AuthorizationFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String command = req.getParameter("command");
        LOG.info("command = " + command);

        if (isAuthorizationRequired(command)) {
            Object user = req.getSession(false).getAttribute("userGlobal");
            if (user == null) {
                return;
            }
            chain.doFilter(request, response);
        }
    }

    private boolean isAuthorizationRequired(String command) {
        if (command == null) {
            return false;
        }
        command = command.toUpperCase();
        return switch (command) {
            case "REGISTER",
                    "REGISTER_USER_FORM",
                    "LOGIN",
                    "LOGIN_PAGE",
                    "ADD_TO_CART",
                    "ERROR",
                    "BOOK",
                    "BOOKS" -> false;

            default -> true;
        };
    }
}
//    REGISTER
//    REGISTER_USER_FORM
//    EDIT_PROFILE
//    EDIT_PROFILE_FORM
//    PROFILE
//    USERS
//    DELETE_USER
//    ADD_BOOK
//    ADD_BOOK_FORM
//    EDIT_BOOK
//    EDIT_BOOK_FORM
//    BOOK
//    BOOKS
//    DELETE_BOOK
//    CREATE_ORDER
//    CREATE_ORDER_FORM
//    ORDER
//    ORDERS
//    DELETE_ORDER
//    ERROR
//    ADD_TO_CART
//    LOGIN
//    LOGIN_PAGE