package com.company.bookseller.controller.impl;

import com.company.bookseller.controller.Command;
import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class AddToCartCommand implements Command {
    @Override
    @SuppressWarnings("unchecked")
    public String execute(HttpServletRequest req) {
        Long bookId = Long.valueOf(req.getParameter("book_id"));
        Object rawCart = req.getSession().getAttribute("cart");
        Map<Long, Integer> cart;
        if (rawCart != null) {
            cart = (Map<Long, Integer>) rawCart;
        } else {
            cart = new HashMap<>();
        }
        Integer quantity = cart.get(bookId);
        if (quantity == null) {
            cart.put(bookId, 1);
        } else {
            cart.put(bookId, ++quantity);
        }
        req.getSession().setAttribute("cart", cart);
        String from = req.getParameter("from");

        return from != null ? from : "jsp/allBooks.jsp";
    }
}