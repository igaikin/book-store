//package com.company.bookseller.controller.commands.impl.order;
//
//import com.company.bookseller.controller.commands.Command;
//import com.company.bookseller.dao.entity.OrderItem;
//import com.company.bookseller.service.BookService;
//import com.company.bookseller.service.OrderService;
//import com.company.bookseller.service.dto.BookDto;
//import com.company.bookseller.service.dto.OrderDto;
//import com.company.bookseller.service.dto.UserDto;
//import com.company.bookseller.service.impl.BookServiceImpl;
//import com.company.bookseller.service.impl.OrderServiceImpl;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
//import java.util.ArrayList;
//import java.util.List;
//
//public class GetCartCommand implements Command {
//    private static final BookService BOOK_SERVICE = new BookServiceImpl();
//    private static final OrderService ORDER_SERVICE = new OrderServiceImpl();
//
//    @Override
//    public String execute(HttpServletRequest req) {
//        HttpSession session = req.getSession();
//        UserDto user = (UserDto) session.getAttribute("user");
//        OrderDto order = (OrderDto) session.getAttribute("order");
//        String id = req.getParameter("id");
//        String sQuantity = req.getParameter("quantity");
//        Integer iQuantity = Integer.parseInt(sQuantity);
//        BookDto book = BOOK_SERVICE.get(Long.valueOf(id));
//        if (order == null) {
//            order = new OrderDto();
//            OrderItem item = new OrderItem();
//            item.setPrice(book.getPrice());
//            item.setQuantity(iQuantity);
//            List<OrderItem> items = new ArrayList<>();
//            items.add(item);
//            session.setAttribute("order", order);
//            order.setTotalPrice(order.getTotalPrice() + book.getPrice() * iQuantity);
//        }
//        session.setAttribute("cart", order);
//        return "/pages/order.jsp";
//
//
//    }
//}
