package com.company.bookseller.model.service.impl;

import com.company.bookseller.model.dao.OrderItemDao;
import com.company.bookseller.model.dao.impl.OrderItemDaoJdbcImpl;
import com.company.bookseller.model.dto.BookDto;
import com.company.bookseller.model.dto.OrderDto;
import com.company.bookseller.model.dto.UserDto;
import com.company.bookseller.model.entity.Order;
import com.company.bookseller.model.dao.BookDao;
import com.company.bookseller.model.dao.OrderDao;
import com.company.bookseller.model.dao.UserDao;
import com.company.bookseller.model.dao.impl.BookDaoJdbcImpl;
import com.company.bookseller.model.dao.impl.OrderDaoJdbcImpl;
import com.company.bookseller.model.dao.impl.UserDaoJdbcImpl;
import com.company.bookseller.model.entity.OrderItem;
import com.company.bookseller.model.service.BookService;
import com.company.bookseller.model.service.OrderService;
import com.company.bookseller.model.service.UserService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {
    private final BookDao bookDao = new BookDaoJdbcImpl();
    private final BookService bookService = new BookServiceImpl();
    private final OrderDao orderDao = new OrderDaoJdbcImpl();
    private final OrderItemDao orderItemDao = new OrderItemDaoJdbcImpl();
    private final UserDao userDao = new UserDaoJdbcImpl();
    private final UserService userService = new UserServiceImpl();

    @Override
    public List<OrderDto> getAll() {
        return orderDao.getAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());

    }

    @Override
    public OrderDto get(Long id) {
        Order order = orderDao.get(id);
        return mapToDto(order);
    }

    private OrderDto mapToDto(Order order) {
        List<OrderItem> orderItems = orderItemDao.getByOrderId(order.getId());
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        UserDto userDto = userService.get(orderDto.getId());
        orderDto.setUser(userDto);
        orderDto.setStatus(OrderDto.StatusDto.valueOf(order.getStatus().toString()));
        orderDto.setTotalPrice(order.getTotalPrice());
        orderDto.setOrderTime(order.getOrderTime());

        Map<BookDto, Integer> orderItemsDto = new HashMap<>();
        for (OrderItem orderItem : orderItems) {
            BookDto bookDto = bookService.get(orderItem.getBookId());
            BigDecimal oldPrice = orderItem.getPrice();
            bookDto.setPrice(oldPrice);
            Integer quantity = orderItem.getQuantity();
            orderItemsDto.put(bookDto, quantity);
        }
        orderDto.setItems(orderItemsDto);
        return orderDto;
    }

    @Override
    public OrderDto create(OrderDto orderDto) {
        Order order = mapToEntity(orderDto);
        Order createdOrder = orderDao.create(order);
        List<OrderItem> orderItems = mapToEntity(orderDto.getItems(), createdOrder.getId());
        for (OrderItem orderItem : orderItems) {
            orderItemDao.create(orderItem);
        }
        return get(createdOrder.getId());
    }

    private Order mapToEntity(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setStatus(Order.Status.valueOf(orderDto.getStatus().toString()));
        order.setTotalPrice(orderDto.getTotalPrice());
        order.setOrderTime(orderDto.getOrderTime());
        order.setUserId(orderDto.getUser().getId());
        return order;
    }

    private List<OrderItem> mapToEntity(Map<BookDto, Integer> orderItemsDto, Long orderId) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (Map.Entry<BookDto, Integer> orderItemDto : orderItemsDto.entrySet()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(orderId);
            orderItem.setBookId(orderItemDto.getKey().getId());
            orderItem.setQuantity(orderItemDto.getValue());
            orderItem.setPrice(orderItemDto.getKey().getPrice());
            orderItems.add(orderItem);
        }
    }

    @Override
    public OrderDto update(OrderDto order) {
        return orderDao.update(order);
    }

    @Override
    public boolean delete(Long id) {
        return orderDao.delete(id);
    }

    @Override
    public List<OrderDto> getOrderByBookId(Long bookId) {
//        List<Order> orders = (OrderDao.getByBookId(bookId));
//        if (orders == null) {
//            return null;
//        }
//        orders.forEach(b -> {
//            b.setBooks((List<Book>) bookDao.getById(bookId));
//            orders.add(b);
//        });
//        return orders;
        throw new UnsupportedOperationException();
    }

    @Override
    public List<OrderDto> getOrderByUserId(Long userId) {
//        List<Order> orders = (List<Order>) OrderDao.getByUserId(userId);
//        if (orders == null) {
//            return null;
//        }
//        orders.forEach(u -> {
//            u.setUser((List<User>) userDao.getById(userId));
//            orders.add(u);
//        });
//        return orders;
        throw new UnsupportedOperationException();
    }
}
