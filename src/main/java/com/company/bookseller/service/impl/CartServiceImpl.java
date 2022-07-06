package com.company.bookseller.service.impl;

import com.company.bookseller.controller.commands.impl.order.CartCommand;
import com.company.bookseller.service.CartService;
import com.company.bookseller.service.dto.BookDto;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class CartServiceImpl implements CartService {
    @Override
    public BigDecimal calculateTotalPrice(List<CartCommand.CartItem> items) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (CartCommand.CartItem item : items) {
            totalPrice = totalPrice.add(item.getPrice());
        }
        return totalPrice;
    }

    @Override
    public BigDecimal calculateTotalPrice(Map<BookDto, Integer> items) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Map.Entry<BookDto, Integer> entry : items.entrySet()) {
            BigDecimal itemPrice = entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue()));
            totalPrice = totalPrice.add(itemPrice);
        }
        return totalPrice;
    }
}
