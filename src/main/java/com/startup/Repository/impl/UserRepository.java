package com.startup.Repository.impl;
/*
  @author Lené Prinsloo
 */
import com.startup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserRepository extends JpaRepository<User, String>{

}

