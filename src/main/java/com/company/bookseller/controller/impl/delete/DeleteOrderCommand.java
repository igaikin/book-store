package com.company.bookseller.controller.impl.delete;

import com.company.bookseller.controller.Command;
import com.company.bookseller.service.OrderService;
import com.company.bookseller.service.dto.OrderDto;
import com.company.bookseller.service.impl.OrderServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class DeleteOrderCommand implements Command {
    private static final OrderService ORDER_SERVICE = new OrderServiceImpl();

    @Override
    public String execute(HttpServletRequest req) {
        String id = req.getParameter("id");
        OrderDto order = ORDER_SERVICE.get(Long.valueOf(id));
        if (order == null) {
            req.setAttribute("message", "Book with ID: " + id + "not found");
            return "jsp/error.jsp";
        }
        order.setStatus(OrderDto.StatusDto.valueOf(req.getParameter("CANCELLED")));
        OrderDto removeOrder = ORDER_SERVICE.update(order);
        req.setAttribute("order", removeOrder);//?????????????
        return "jsp/allBooks.jsp";
    }
}