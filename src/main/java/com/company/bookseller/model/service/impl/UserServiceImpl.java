package com.company.bookseller.model.service.impl;

import com.company.bookseller.model.dao.UserDao;
import com.company.bookseller.model.dao.impl.UserDaoJdbcImpl;
import com.company.bookseller.model.dto.UserDto;
import com.company.bookseller.model.entity.User;
import com.company.bookseller.model.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

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
        return get(userToEntity(userDto).getId());
    }

    @Override
    public UserDto update(UserDto userDto) {
        return null;
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
