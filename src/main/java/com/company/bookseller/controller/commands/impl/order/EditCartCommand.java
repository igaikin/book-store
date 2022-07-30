package com.company.bookseller.controller.commands.impl.order;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.service.BookService;
import com.company.bookseller.service.CartService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Map;

public class EditCartCommand implements Command {
    private final BookService bookService;
    private final CartService cartService;

    public EditCartCommand(BookService bookService, CartService cartService) {
        this.bookService = bookService;
        this.cartService = cartService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        return null;
    }

    private void addBookToCart(Long bookId, Map<Long, Integer> cart) {
        Integer quantity = cart.get(bookId);
        if (quantity == null) {
            cart.put(bookId, 1);
        } else {
            cart.put(bookId, quantity + 1);
        }
    }

    private void removeBookAtCart(Long bookId, Map<Long, Integer> cart) {
        Integer quantity = cart.get(bookId);
        if (quantity == 1) {
            cart.remove(bookId);
        } else {
            cart.put(bookId, quantity - 1);
        }
    }
}
