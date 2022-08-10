package com.company.bookseller.controller.commands.impl.order;

import java.util.Map;

public class CartUtil {

    public static void addBookToCart(Long bookId, Map<Long, Integer> cart) {
        Integer quantity = cart.get(bookId);
        if (quantity == null) {
            cart.put(bookId, 1);
        } else {
            cart.put(bookId, quantity + 1);
        }
    }

    public static void removeBookAtCart(Long bookId, Map<Long, Integer> cart) {
        Integer quantity = cart.get(bookId);
        if (quantity == 1) {
            cart.remove(bookId);
        } else {
            cart.put(bookId, quantity - 1);
        }
    }
}
