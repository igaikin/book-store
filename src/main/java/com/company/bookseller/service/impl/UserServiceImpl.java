package com.company.bookseller.service.impl;

import com.company.bookseller.dao.UserDao;
import com.company.bookseller.dao.connection.ConnectionManager;
import com.company.bookseller.dao.entity.User;
import com.company.bookseller.dao.impl.UserDaoJdbcImpl;
import com.company.bookseller.service.UserService;
import com.company.bookseller.service.dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserServiceImpl implements UserService {
    private static final Logger LOG = LogManager.getLogger(UserServiceImpl.class);
    private final UserDao userDao = new UserDaoJdbcImpl();

    private User userToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setRole(User.Role.valueOf(userDto.getRole().toString()));
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }

    private UserDto userToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setRole(UserDto.Role.valueOf(user.getRole().toString()));
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    @Override
    public List<UserDto> getAll() {
        return userDao.getAll()
                .stream()
                .map(this::userToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto get(Long id) {
        return userToDto(userDao.get(id));
    }

    @Override
    public UserDto create(UserDto userDto) {
        User existing = userDao.getByEmail(userDto.getEmail());
        if (existing != null) {
            throw new RuntimeException("User with email: " + userDto.getEmail() + " already exists");
        }
        User created = userDao.create(userToEntity(userDto));
        return get(created.getId());
    }

    @Override
    public UserDto update(UserDto userDto) {
        User existing = userDao.getByEmail(userDto.getEmail());
        if (existing == null) {
            throw new RuntimeException("User with email: " + userDto.getEmail() + " does not exist");
        }
        User updated = userDao.update(userToEntity(userDto));
        return get(updated.getId());
    }

    public void delete(Long id) {
        if (!userDao.delete(id)) {
            throw new RuntimeException("User with [id=" + id + "]");
        }
    }
}
