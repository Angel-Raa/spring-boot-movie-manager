package com.github.angel.service.impl;

import com.github.angel.exception.GlobalDefaultException;
import com.github.angel.persistence.entity.User;
import com.github.angel.persistence.repository.UserRepository;
import com.github.angel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public List<User> getAll() {
        return this.repository.findAll();
    }

    @Override
    public List<User> getAllByName(String name) {
        return this.repository.findByNameContaining(name);
    }

    @Override
    public User getByUsername(String username) {
        return this.repository.findByUsername(username).orElseThrow(() -> new GlobalDefaultException("Not found username"));
    }

    @Override
    public void save(User user) {
        this.repository.save(user);
    }

    @Override
    public void update(User user, String username) {
        User update = this.getByUsername(username);
        update.setName(user.getName());
        update.setPassword(user.getPassword());
        this.repository.save(update);
    }


    @Override
    public void deleteByUsername(String username) {
        User user = this.getByUsername(username);
        this.repository.save(user);
    }
}
