package com.company.bookseller.service;

import com.company.bookseller.dao.BookDao;
import com.company.bookseller.dao.DaoFactory;
import com.company.bookseller.dao.OrderDao;
import com.company.bookseller.dao.UserDao;
import com.company.bookseller.service.impl.BookServiceImpl;
import com.company.bookseller.service.impl.CartServiceImpl;
import com.company.bookseller.service.impl.OrderServiceImpl;
import com.company.bookseller.service.impl.UserServiceImpl;
import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {
    public static ServiceFactory getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        static final ServiceFactory INSTANCE = new ServiceFactory();
    }

    private final Map<Class<?>, Object> map;

    private ServiceFactory() {
        map = new HashMap<>();
        map.put(BookService.class, new BookServiceImpl(DaoFactory.getInstance().getDao(BookDao.class)));
        map.put(UserService.class, new UserServiceImpl(DaoFactory.getInstance().getDao(UserDao.class)));
        map.put(CartService.class, new CartServiceImpl());
        map.put(OrderService.class, new OrderServiceImpl(DaoFactory.getInstance().getDao(OrderDao.class)));
    }

    @SuppressWarnings("unchecked")
    public <T> T getService(Class<T> serviceName) {
        return (T) map.get(serviceName);
    }
}
