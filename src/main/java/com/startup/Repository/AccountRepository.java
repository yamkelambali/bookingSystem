package com.startup.Repository;
/**
 * @author Michael Bezuidenhout
 */

import com.startup.Repository.IRepository;
import com.startup.entity.Account;

import java.util.Set;

public interface AccountRepository extends IRepository<Account, String> {
    Set<Account> getAll();
}
