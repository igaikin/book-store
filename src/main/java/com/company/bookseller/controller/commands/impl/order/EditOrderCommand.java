package com.company.bookseller.controller.commands.impl.order;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.service.OrderService;
import com.company.bookseller.service.dto.OrderDto;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

public class EditOrderCommand implements Command {
    private final OrderService orderService;

    public EditOrderCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        String id = req.getParameter("id");
        OrderDto order = orderService.get(Long.valueOf(id));
        order.setOrderDateTime(LocalDateTime.now());
        order.setStatus(OrderDto.StatusDto.valueOf("status"));

        OrderDto editOrder = orderService.update(order);
        req.setAttribute("order", editOrder);
        return "jsp/order.jsp";
    }
}
