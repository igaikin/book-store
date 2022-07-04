package com.company.bookseller.dao;

import com.company.bookseller.dao.impl.BookDaoJdbcImpl;
import com.company.bookseller.dao.impl.OrderDaoJdbcImpl;
import com.company.bookseller.dao.impl.OrderItemDaoJdbcImpl;
import com.company.bookseller.dao.impl.UserDaoJdbcImpl;
import java.util.HashMap;
import java.util.Map;

public class DaoFactory {
    public static DaoFactory getInstance() {
        return DaoFactory.Holder.INSTANCE;
    }

    private static class Holder {
        static final DaoFactory INSTANCE = new DaoFactory();
    }

    private final Map<Class<?>, Object> map;

    private DaoFactory() {
        map = new HashMap<>();
        map.put(BookDao.class, new BookDaoJdbcImpl());
        map.put(UserDao.class, new UserDaoJdbcImpl());
        map.put(OrderItemDao.class, new OrderItemDaoJdbcImpl());
        map.put(OrderDao.class, new OrderDaoJdbcImpl());
    }

    @SuppressWarnings("Unchecked")
    public <T> T getDao(Class<T> daoName) {
        return (T) map.get(daoName);
    }
}
