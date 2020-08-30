package com.startup.Repository.impl.impl;
/**
 * @author Michael Bezuidenhout
 */

import com.startup.Repository.impl.IRepository;
import com.startup.entity.Account;

import java.util.Set;

public interface AccountRepository extends IRepository<Account, String> {
    Set<Account> getAll();
}
