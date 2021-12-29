package com.company.bookseller.model.service.impl;

import com.company.bookseller.model.beans.Book;
import com.company.bookseller.model.beans.Order;
import com.company.bookseller.model.beans.User;
import com.company.bookseller.model.dao.BookDao;
import com.company.bookseller.model.dao.OrderDao;
import com.company.bookseller.model.dao.UserDao;
import com.company.bookseller.model.dao.impl.BookDaoJdbcImpl;
import com.company.bookseller.model.dao.impl.OrderDaoJdbcImpl;
import com.company.bookseller.model.dao.impl.UserDaoJdbcImpl;
import com.company.bookseller.model.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final BookDao bookDao = new BookDaoJdbcImpl();
    private final OrderDao orderDao = new OrderDaoJdbcImpl();
    private final UserDao userDao = new UserDaoJdbcImpl();

    @Override
    public Order getById(long id) {
        Order order = orderDao.get(id);
        if (order != null) {
            processOrder(order);
        }
        return order;
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = orderDao.getAll();
        orders.forEach(this::processOrder);
        return orders;
    }

    private void processOrder(Order order) {
        User user = userDao.get(order.getUser().getId());
        order.setUser(user);
        Book book = bookDao.get(order.getBook().getId());
        order.setBook(book);
    }

    @Override
    public List<Order> getOrderByBookId(long bookId) {
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
    public List<Order> getOrderByUserId(long userId) {
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
