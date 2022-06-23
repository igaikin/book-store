package com.company.bookseller.controller.commands.impl.order;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.service.BookService;
import com.company.bookseller.service.CartService;
import com.company.bookseller.service.dto.BookDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class CartCommand implements Command {
    private final BookService bookService;
    private final CartService cartService;

    public CartCommand(BookService bookService, CartService cartService) {
        this.bookService = bookService;
        this.cartService = cartService;
    }

    @Override
    @SuppressWarnings("unchecked")
    public String execute(HttpServletRequest req) {
        HttpSession session = req.getSession();
        Object cartObj = session.getAttribute("cart");
        Map<Long, Integer> cart;
        if (cartObj != null) {
            cart = (Map<Long, Integer>) cartObj;
        } else {
            return "jsp/emptyCart.jsp";
        }
        List<CartItem> items = new ArrayList<>();
        cart.forEach((bookId, quantity) -> {
            BookDto book = bookService.get(bookId);
            BigDecimal price = book.getPrice().multiply(BigDecimal.valueOf(quantity));
            items.add(new CartItem(book, quantity, price));
        });
        req.setAttribute("cart", items);
        BigDecimal totalPrice = cartService.calculateTotalPrice(items);
        req.setAttribute("totalPrice", totalPrice);
        return "jsp/cart.jsp";
    }

    @Getter @AllArgsConstructor
    public static class CartItem {
        private final BookDto book;
        private final Integer quantity;
        private final BigDecimal price;
    }
}
