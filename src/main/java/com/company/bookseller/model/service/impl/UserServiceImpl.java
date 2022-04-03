package com.company.bookseller.model.service.impl;

import com.company.bookseller.model.beans.User;
import com.company.bookseller.model.dao.UserDao;
import com.company.bookseller.model.dao.impl.UserDaoJdbcImpl;
import com.company.bookseller.model.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoJdbcImpl();

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User get(Long id) {
        return userDao.get(id);
    }

    public User create(User user) {
        User existing = userDao.getByEmail(user.getEmail());
        if (existing != null) {
            throw new RuntimeException("User with email: " + user.getEmail() + " already exists");
        }
        return userDao.create(user);
    }

    public User update(User user) {
        User existing = userDao.getByEmail(user.getEmail());
        assert existing != null;
        if (user.getId() != existing.getId()) {
            throw new RuntimeException("User with Email: " + user.getEmail() + " does not exist");
        }
        return userDao.update(user);
    }

    public boolean delete(Long id) {
        return userDao.delete(id);
    }
}
