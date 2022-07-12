package com.company.bookseller.controller.commands.impl.order;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.service.OrderService;
import com.company.bookseller.service.dto.OrderDto;
import com.company.bookseller.util.MessageManager;
import jakarta.servlet.http.HttpServletRequest;

public class DeleteOrderCommand implements Command {
    private final OrderService orderService;

    public DeleteOrderCommand(OrderService orderService) {
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
        order.setStatus(OrderDto.StatusDto.valueOf(req.getParameter("CANCELLED")));
        OrderDto removeOrder = orderService.update(order);
        req.setAttribute("order", removeOrder);//?????????????
        return "jsp/allOrders.jsp";
    }
}