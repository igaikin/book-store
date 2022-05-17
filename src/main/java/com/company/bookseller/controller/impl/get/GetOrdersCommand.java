package com.company.bookseller.controller.impl.get;

import com.company.bookseller.controller.Command;
import com.company.bookseller.service.OrderService;
import com.company.bookseller.service.dto.OrderDto;
import com.company.bookseller.service.impl.OrderServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

public class GetOrdersCommand implements Command {
    private static final OrderService ORDER_SERVICE = new OrderServiceImpl();

    @Override
    public String execute(HttpServletRequest req) {
        List<OrderDto> orders = ORDER_SERVICE.getAll();
        req.setAttribute("orders", orders);
        return "jsp/allOrders.jsp";
    }
}
