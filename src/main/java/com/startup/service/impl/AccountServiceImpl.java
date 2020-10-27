package com.startup.service.impl;
/**
 * @author Yamkela Mbali
 */
import com.startup.Repository.impl.AccountRepository;
import com.startup.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repository;

    @Override
    public Set<Account> getAll()
    {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Account create(Account account) {

        return this.repository.save(account);
    }

    @Override
    public Account read(String s) {

        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Account update(Account account)
    {

        return this.repository.save(account);
    }

    @Override
    public boolean delete(String s) {

        this.repository.deleteById(s);
        if (this.repository.existsById(s)) return false;
        else return true;
    }
}
