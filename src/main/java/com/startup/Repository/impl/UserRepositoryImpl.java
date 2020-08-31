package com.startup.Repository.impl;
/*
 @author Lene Prinsloo
*/

import com.startup.entity.User;
import java.util.HashSet;
import java.util.Set;

public class UserRepositoryImpl implements UserRepository{

    private static UserRepository repository = null;
    private Set<User> userDB;

    private UserRepositoryImpl() { this.userDB = new HashSet<>();
    }

    public static UserRepository getRepository(){
        if (repository == null) repository = new UserRepositoryImpl();
        return repository;
    }

    @Override
    public User create(User user) {
        this.userDB.add(user);
        return user;
    }

    @Override
    public User read(String userId) {
        for (User user : this.userDB){
            if (user.getUserId().equalsIgnoreCase(userId)) return user;
        }
        return null;
    }

    @Override
    public User update(User user) {
        boolean deleteUser = delete(user.getUserId());
        if(deleteUser){
            this.userDB.add(user);
            return user;
        }
        return null;
    }

    @Override
    public boolean delete(String userID) {
        User user = read(userID);
        if(user !=null){
            this.userDB.remove(user);
        }
        return false;
    }

    @Override
    public Set<User> getAll() {
        return null;
    }
}
