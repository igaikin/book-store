package com.company.bookseller.controller;

import com.company.bookseller.service.OrderService;
import com.company.bookseller.service.dto.OrderDto;
import com.company.bookseller.service.impl.OrderServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orders")
public class OrderController extends HttpServlet {
    private static final OrderService ORDER_SERVICE = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id == null) {
            List<OrderDto> orders = ORDER_SERVICE.getAll();
            req.setAttribute("orders", orders);
            req.getRequestDispatcher("allOrders.jsp").forward(req, resp);
        } else {
            OrderDto order = ORDER_SERVICE.get(Long.valueOf(id));
            req.setAttribute("order", order);
            req.getRequestDispatcher("order.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
