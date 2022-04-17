package com.company.bookseller.dao;

import com.company.bookseller.dao.entity.User;

public interface UserDao extends AbstractDao<User, Long> {
    User getByEmail(String email);
}
