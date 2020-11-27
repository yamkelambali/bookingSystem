package com.startup.service.impl;
/**
 * @author Yamkela Mbali
 */
import com.startup.entity.User;
import com.startup.service.IService;

import java.util.List;
import java.util.Set;

public interface UserService extends IService <User, String> {

    Set<User> getAll();

}
