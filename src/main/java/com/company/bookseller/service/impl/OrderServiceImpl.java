package com.company.bookseller.service.impl;

import com.company.bookseller.dao.DaoFactory;
import com.company.bookseller.dao.OrderDao;
import com.company.bookseller.dao.OrderItemDao;
import com.company.bookseller.dao.entity.Order;
import com.company.bookseller.dao.entity.OrderItem;
import com.company.bookseller.service.BookService;
import com.company.bookseller.service.OrderService;
import com.company.bookseller.service.ServiceFactory;
import com.company.bookseller.service.UserService;
import com.company.bookseller.service.dto.BookDto;
import com.company.bookseller.service.dto.OrderDto;
import com.company.bookseller.service.dto.UserDto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao;

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
//
//    @Override
//    public List<OrderDto> getAll() {
//        return orderDao.getAll()
//                .stream()
//                .map(this::orderToDto)
//                .collect(Collectors.toList());
//    }

    @Override
    public List<OrderDto> getAll(int limit, int offset) {
        return orderDao.getAll(limit, offset)
                .stream()
                .map(this::orderToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto get(Long id) {
        Order order = orderDao.get(id);
        return orderToDto(order);
    }

    @Override
    public OrderDto create(OrderDto orderDto) {
        Order order = orderToEntity(orderDto);
        Order createdOrder = orderDao.create(order);
        List<OrderItem> orderItems = orderItemToEntity(orderDto.getItems(), createdOrder.getId());
        for (OrderItem orderItem : orderItems) {
            DaoFactory.getInstance().getDao(OrderItemDao.class).create(orderItem);
        }
        return get(createdOrder.getId());
    }

    private OrderDto orderToDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        UserDto userDto = ServiceFactory.getInstance().getService(UserService.class).get(order.getUserId());
        orderDto.setUser(userDto);
        orderDto.setStatus(OrderDto.StatusDto.valueOf(order.getStatus().toString()));
        orderDto.setTotalPrice(order.getTotalPrice());
        orderDto.setOrderDateTime(order.getOrderDateTime());

        Map<BookDto, Integer> orderItemsDto = new HashMap<>();
        List<OrderItem> orderItems = DaoFactory.getInstance().getDao(OrderItemDao.class).getByOrderId(order.getId());
        for (OrderItem orderItem : orderItems) {
            BookDto bookDto = ServiceFactory.getInstance().getService(BookService.class).get(orderItem.getBookId());
            BigDecimal oldPrice = orderItem.getPrice();
            bookDto.setPrice(oldPrice);
            Integer quantity = orderItem.getQuantity();
            orderItemsDto.put(bookDto, quantity);
        }
        orderDto.setItems(orderItemsDto);
        return orderDto;
    }

    private Order orderToEntity(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setStatus(Order.Status.valueOf(orderDto.getStatus().toString()));
        order.setTotalPrice(orderDto.getTotalPrice());
        order.setOrderDateTime(orderDto.getOrderDateTime());
        order.setUserId(orderDto.getUser().getId());
        return order;
    }

    private List<OrderItem> orderItemToEntity(Map<BookDto, Integer> orderItemsDto, Long orderId) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (Map.Entry<BookDto, Integer> orderItemDto : orderItemsDto.entrySet()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(orderId);
            orderItem.setBookId(orderItemDto.getKey().getId());
            orderItem.setQuantity(orderItemDto.getValue());
            orderItem.setPrice(orderItemDto.getKey().getPrice());
            orderItems.add(orderItem);
        }
        return orderItems;
    }

    @Override
    public OrderDto update(OrderDto orderDto) {
        orderDao.update(orderToEntity(orderDto));
        List<OrderItem> oldItems = DaoFactory.getInstance().getDao(OrderItemDao.class).getByOrderId(orderDto.getId());
        oldItems.forEach(orderItem -> DaoFactory.getInstance().getDao(OrderItemDao.class).delete(orderItem.getId()));

        List<OrderItem> newItems = orderItemToEntity(orderDto.getItems(), orderDto.getId());
        newItems.forEach(orderItem -> DaoFactory.getInstance().getDao(OrderItemDao.class).create(orderItem));
        return get(orderDto.getId());
    }

    @Override
    public void delete(Long id) {
        if (!orderDao.delete(id)) {
            throw new RuntimeException("Couldn't delete order [id=" + id + "]");
        }
    }

    @Override
    public List<OrderDto> getOrderByBookId(Long bookId) {
        List<OrderItem> orderItems = DaoFactory.getInstance().getDao(OrderItemDao.class).getByBookId(bookId);
        List<OrderDto> orders = new ArrayList<>();
        for (OrderItem orderItem : orderItems) {
            Order order = orderDao.get(orderItem.getOrderId());
            OrderDto orderDto = orderToDto(order);
            orders.add(orderDto);
        }
        return orders;
    }

    @Override
    public List<OrderDto> getOrderByUserId(Long userId) {
        return orderDao.getByUserId(userId)
                .stream()
                .map(this::orderToDto)
                .toList();
    }
}
