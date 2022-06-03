//package com.company.bookseller.controller.commands.impl.order;
//
//import com.company.bookseller.controller.commands.Command;
//import com.company.bookseller.service.BookService;
//import com.company.bookseller.service.OrderService;
//import com.company.bookseller.service.UserService;
//import com.company.bookseller.service.dto.BookDto;
//import com.company.bookseller.service.dto.OrderDto;
//import com.company.bookseller.service.dto.UserDto;
//import com.company.bookseller.service.impl.BookServiceImpl;
//import com.company.bookseller.service.impl.OrderServiceImpl;
//import com.company.bookseller.service.impl.UserServiceImpl;
//import jakarta.servlet.http.HttpServletRequest;
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//public class CreateOrderCommand implements Command {
//    private static final Logger LOG = LogManager.getLogger(CreateOrderCommand.class);
//    private static final OrderService ORDER_SERVICE = new OrderServiceImpl();
//    private static final UserService USER_SERVICE = new UserServiceImpl();
//    private static final BookService BOOK_SERVICE = new BookServiceImpl();
//
//    @Override
//    public String execute(HttpServletRequest req) {
//        OrderDto order = new OrderDto();
//
//        order.setStatus(OrderDto.StatusDto.valueOf(req.getParameter("status")));
//        String id = req.getParameter("id");
//        UserDto user = USER_SERVICE.get(Long.valueOf(id));
////        order.setUser(req.getParameter("user"));
//        order.setOrderDateTime(LocalDateTime.parse(req.getParameter("orderDateTime")));
//        List<BookDto> items = new ArrayList<>();
//        BookDto book = BOOK_SERVICE.get(Long.valueOf(id));
//        items.add(book);
////        order.item(req.getParameter("items"));
//        order.setTotalPrice(new BigDecimal(req.getParameter("totalPrice")));
//        OrderDto createdOrder = ORDER_SERVICE.create(order);
//        req.setAttribute("order", createdOrder);
//        return "jsp/order.jsp";
//    }
//}
