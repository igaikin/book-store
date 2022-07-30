package com.company.bookseller.controller.commands.impl.order;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.service.OrderService;
import com.company.bookseller.service.dto.OrderDto;
import com.company.bookseller.util.MessageManager;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

public class GetMyOrdersCommand implements Command {
    private final OrderService orderService;

    public GetMyOrdersCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        String id = req.getParameter("id");
        List<OrderDto> orders = orderService.getOrderByUserId(Long.valueOf(id));
        if (orders == null) {
            req.setAttribute("message", MessageManager.getMessage("msg.orderNotFound"));
            return "jsp/error.jsp";
        }
        req.setAttribute("orders", orders);
        return "jsp/allOrders.jsp";
    }
}
