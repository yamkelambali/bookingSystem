package com.startup.Repository.impl;
/*
  @author Lené Prinsloo
 */
import com.startup.Repository.IRepository;
import com.startup.entity.User;

import java.util.Set;

public interface UserRepository extends IRepository <User, String> {

    Set<User> getAll();
}
