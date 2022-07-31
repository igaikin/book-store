package com.company.bookseller.controller.filters;

import com.company.bookseller.util.MessageManager;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.log4j.Log4j2;

@Log4j2
@WebFilter("/controller")
public class AuthorizationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String command = req.getParameter("command");
        log.info("command = " + command);

        if (UserRoleUtil.isAuthorizationRequired(command)) {
            Object user = req.getSession(false).getAttribute("userGlobal");
            if (user == null) {
                ((HttpServletResponse) response).setStatus(401);
                req.setAttribute("message", MessageManager.getMessage("msg.loginOrSign"));
                req.getRequestDispatcher("jsp/error.jsp").forward(request, response);
                return;
            }
        }
        chain.doFilter(request, response);
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