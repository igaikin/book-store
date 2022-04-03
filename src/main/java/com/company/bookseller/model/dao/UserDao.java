package com.company.bookseller.model.dao;

import com.company.bookseller.model.entity.User;

public interface UserDao extends AbstractDao<User, Long> {
    User getByEmail(String email);
}
