package com.startup.service.impl;
/**
 * @author Yamkela Mbali
 */
import com.startup.Repository.impl.UserRepository;
import com.startup.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public Set<User> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public User create(User user) {

        return this.repository.save(user);
    }

    @Override
    public User read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public User update(User user) {

        return this.repository.save(user);
    }

    @Override
    public boolean delete(String s) {

        this.repository.deleteById(s);
        if (this.repository.existsById(s)) return false;
        else return true;
    }
}
