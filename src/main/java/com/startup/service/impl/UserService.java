package com.startup.service.impl;

import com.startup.entity.User;
import com.startup.service.IService;

import java.util.Set;

public interface UserService extends IService <User, String> {

    Set<User> getAll();
}
