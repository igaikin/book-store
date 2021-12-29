package com.company.bookseller.model.service;

import com.company.bookseller.model.beans.User;

import java.util.List;

public interface UserService {
    User getById(long id);

    List<User> getAll();
}
