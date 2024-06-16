package com.github.angel.service;

import com.github.angel.persistence.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    List<User> getAllByName(String name);
    User getByUsername(String username);
    void save(User user);
    void update(User user, String username);
    void deleteByUsername(String username);

}
