package com.company.bookseller.controller.impl.order;

import com.company.bookseller.controller.Command;
import jakarta.servlet.http.HttpServletRequest;

public class CreateOrderFormCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {
        return "jsp/createOrderForm.jsp";
    }
}
