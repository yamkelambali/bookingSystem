package com.startup.Repository.impl;

import com.startup.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AccountRepository extends JpaRepository<Account, String>{

}

