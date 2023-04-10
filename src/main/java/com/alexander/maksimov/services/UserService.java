package com.alexander.maksimov.services;

import com.alexander.maksimov.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findOne(int id);

    void save(User user);

    void update(User user);

    void delete(int id);
}
