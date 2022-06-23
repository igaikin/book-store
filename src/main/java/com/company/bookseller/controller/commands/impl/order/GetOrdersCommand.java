package com.company.bookseller.controller.commands.impl.order;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.service.OrderService;
import com.company.bookseller.service.dto.OrderDto;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

public class GetOrdersCommand implements Command {
    private final OrderService orderService;

    public GetOrdersCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest req) {
//        getUserOrdersCommand
//        Long id = ((UserDto) req.getSession(false).getAttribute("userGlobal")).getId();
//        List<OrderDto> userOrders = ORDER_SERVICE.getOrderByUserId(id);

        List<OrderDto> orders = orderService.getAll();
        req.setAttribute("orders", orders);
        return "jsp/allOrders.jsp";
    }
}
