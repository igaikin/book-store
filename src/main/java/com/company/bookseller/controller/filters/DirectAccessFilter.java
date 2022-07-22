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

@WebFilter(urlPatterns = {"/jsp/*"})
public class DirectAccessFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        ((HttpServletResponse) response).setStatus(403);
        req.setAttribute("message", MessageManager.getMessage("msg.accessForbidden))"));
        req.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
    }
}
