package com.company.bookseller.controller.commands.impl.order;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.service.OrderService;
import com.company.bookseller.service.dto.OrderDto;
import com.company.bookseller.util.MessageManager;
import jakarta.servlet.http.HttpServletRequest;

public class GetOrderCommand implements Command {
    private final OrderService orderService;

    public GetOrderCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        String id = req.getParameter("id");
        OrderDto order = orderService.get(Long.valueOf(id));
        if (order == null) {
            req.setAttribute("message", MessageManager.getMessage("msg.orderNotFound"));
            return "jsp/error.jsp";
        }
        req.setAttribute("order", order);
        return "jsp/order.jsp";
    }
}
