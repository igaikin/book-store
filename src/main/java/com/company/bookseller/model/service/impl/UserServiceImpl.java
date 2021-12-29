package com.company.bookseller.model.service.impl;

import com.company.bookseller.model.beans.User;
import com.company.bookseller.model.dao.UserDao;
import com.company.bookseller.model.dao.impl.UserDaoJdbcImpl;
import com.company.bookseller.model.service.OrderService;
import com.company.bookseller.model.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoJdbcImpl();
    private final OrderService orderService = new OrderServiceImpl();

    @Override
    public User getById(long id) {
        User user = userDao.get(id);
        return user;
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
}
