package com.startup.service.impl;
/**
 * @author Yamkela Mbali
 */
import com.startup.entity.Account;
import com.startup.service.IService;

import java.util.Set;

public interface AccountService extends IService<Account, String> {
    Set<Account> getAll();
}
