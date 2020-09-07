package com.startup.service.impl;
/**
 * @author Yamkela Mbali
 */
import com.startup.Repository.impl.UserRepository;
import com.startup.Repository.impl.UserRepositoryImpl;
import com.startup.entity.User;

import java.util.HashSet;
import java.util.Set;

public class UserServiceImpl implements UserService {
    private static UserService service = null;
    private UserRepository repository;

    private UserServiceImpl() {

        this.repository = UserRepositoryImpl.getRepository();
    }

    public static UserService getService(){
        if (service == null) service = new UserServiceImpl();
        return service;
    }
    @Override
    public Set<User> getAll() {
        return this.repository.getAll();
    }

    @Override
    public User create(User user) {
        return this.repository.create(user);
    }

    @Override
    public User read(String s) {
        return this.repository.read(s);
    }

    @Override
    public User update(User user) {
        return this.repository.update(user);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
