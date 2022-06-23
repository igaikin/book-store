package com.company.bookseller.service;

import com.company.bookseller.controller.commands.impl.order.CartCommand;
import com.company.bookseller.service.dto.BookDto;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface CartService {
    BigDecimal calculateTotalPrice(List<CartCommand.CartItem> items);
    BigDecimal calculateTotalPrice(Map<BookDto, Integer> items);
}
