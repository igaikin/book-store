package com.company.bookseller.controller.commands.impl.order;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.service.OrderService;
import com.company.bookseller.service.dto.OrderDto;
import com.company.bookseller.service.util.paging.Paging;
import com.company.bookseller.service.util.paging.PagingUtil;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

public class GetOrdersCommand implements Command {
    private final OrderService orderService;

    public GetOrdersCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        Paging paging = PagingUtil.extractPaging(req);
        List<OrderDto> orders = orderService.getAll(paging.getLimit(), paging.getOffset());
        req.setAttribute("currentPage", PagingUtil.getCurrentPage(paging));
        req.setAttribute("lastPage", PagingUtil.getTotalPages(orderService.count(), paging.getLimit()));
        req.setAttribute("orders", orders);
        return "jsp/allOrders.jsp";
    }
}
