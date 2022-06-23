package com.company.bookseller.controller.commands.impl.order;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.service.BookService;
import com.company.bookseller.service.CartService;
import com.company.bookseller.service.OrderService;
import com.company.bookseller.service.dto.BookDto;
import com.company.bookseller.service.dto.OrderDto;
import com.company.bookseller.service.dto.UserDto;
import com.company.bookseller.util.MessageManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CreateOrderCommand implements Command {
    private final BookService bookService;
    private final CartService cartService;
    private final OrderService orderService;

    public CreateOrderCommand(BookService bookService, CartService cartService, OrderService orderService) {
        this.bookService = bookService;
        this.cartService = cartService;
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        HttpSession session = req.getSession();
        UserDto user = (UserDto) session.getAttribute("userGlobal");
        if (user == null) {
            req.setAttribute("message", "notSign");
            return "jsp/login.jsp";
        }

        @SuppressWarnings("unchecked")
        Object cartObj = session.getAttribute("cart");
        Map<Long, Integer> cart;
        if (cartObj != null) {
            cart = (Map<Long, Integer>) cartObj;
        } else {
            return "jsp/emptyCart.jsp";
        }

        OrderDto order = new OrderDto();
        order.setOrderDateTime(LocalDateTime.now());
        order.setStatus(OrderDto.StatusDto.PENDING);
        order.setUser(user);
        Map<BookDto, Integer> items = new HashMap<>();
        cart.forEach((bookId, quantity) -> {
            BookDto bookDto = bookService.get(bookId);
            items.put(bookDto, quantity);
        });
        order.setItems(items);
        order.setTotalPrice(cartService.calculateTotalPrice(items));
        OrderDto created = orderService.create(order);
        req.setAttribute("order", created);
        req.setAttribute("message", MessageManager.getMessage("emptyCart"));
        return "jsp/order.jsp";
    }
}

