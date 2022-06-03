package com.company.bookseller.service;

import com.company.bookseller.service.dto.UserDto;

public interface UserService extends AbstractService<UserDto, Long> {
    UserDto getByEmail(String email);

    boolean login(String email, String password);
}
