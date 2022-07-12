package com.company.bookseller.controller.filters;

import com.company.bookseller.service.dto.UserDto;
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

import static com.company.bookseller.service.dto.UserDto.Role.ADMIN;

@WebFilter("/controller")
public class RoleFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String command = req.getParameter("command");
        if (UserRoleUtil.isAuthorizationRequired(command)) {
            UserDto user = (UserDto) req.getSession(false).getAttribute("userGlobal");
            if (user == null || isRestricted(command, user.getRole())) {
                ((HttpServletResponse) response).setStatus(403);
                req.setAttribute("message", MessageManager.getMessage("msg.accessForbidden"));
                req.getRequestDispatcher("jsp/error.jsp").forward(request, response);
                return;
            }
        }
        chain.doFilter(request, response);
    }

    private boolean isRestricted(String command, UserDto.Role role) {
        return (UserRoleUtil.isAdminAction(command) && role != ADMIN)
                || (UserRoleUtil.isManagerAction(command) && role != UserDto.Role.MANAGER && role != UserDto.Role.ADMIN);
    }
}