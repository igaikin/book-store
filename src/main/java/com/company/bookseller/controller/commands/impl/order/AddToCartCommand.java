package com.company.bookseller.controller.commands.impl.order;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.controller.commands.CommandFactory;
import com.company.bookseller.util.MessageManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class AddToCartCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        HttpSession session = req.getSession();
        Map<Long, Integer> cart = getCart(session);

        Long bookId = Long.valueOf(req.getParameter("book_id"));
        addBookToCart(bookId, cart);
        session.setAttribute("cart", cart);
        req.setAttribute("message", MessageManager.getMessage("msg.addToCart"));
        return CommandFactory.getInstance().getCommand("books").execute(req);
    }

    private void addBookToCart(Long bookId, Map<Long, Integer> cart) {
        Integer quantity = cart.get(bookId);
        if (quantity == null) {
            cart.put(bookId, 1);
        } else {
            cart.put(bookId, quantity + 1);
        }
    }

    @SuppressWarnings("unchecked")
    private Map<Long, Integer> getCart(HttpSession session) {
        Object rawCart = session.getAttribute("cart");
        Map<Long, Integer> cart;
        if (rawCart != null) {
            cart = (Map<Long, Integer>) rawCart;
        } else {
            cart = new HashMap<>();
        }
        return cart;
    }
}
