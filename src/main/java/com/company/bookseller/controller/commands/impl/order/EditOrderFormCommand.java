package com.company.bookseller.controller.commands.impl.order;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.service.OrderService;
import com.company.bookseller.service.dto.OrderDto;
import com.company.bookseller.util.MessageManager;
import jakarta.servlet.http.HttpServletRequest;

public class EditOrderFormCommand implements Command {
    private final OrderService orderService;

    public EditOrderFormCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        String id = req.getParameter("id");
        OrderDto editOrder = orderService.get(Long.valueOf(id));
        req.setAttribute("id", id);
        req.setAttribute("order", editOrder);
        if (editOrder == null) {
            req.setAttribute("message", MessageManager.getMessage("msg.orderNotFound"));
            return "jsp/error.jsp";
        }
        return "jsp/editOrderForm.jsp";
    }
}
