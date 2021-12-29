package com.company.bookseller.model.dao;

import com.company.bookseller.model.beans.entities.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    User getById(long id);

    User getByOrderId(long groupId);


}
