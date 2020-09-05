package com.startup.service.impl;

import com.startup.Repository.impl.AccountRepository;
import com.startup.Repository.impl.AccountRepositoryImpl;
import com.startup.Repository.impl.UserRepositoryImpl;
import com.startup.entity.Account;

import java.util.HashSet;
import java.util.Set;

public class AccountServiceImpl implements AccountService {
    private static AccountService service = null;
    private AccountRepository repository;

    private AccountServiceImpl() {

        this.repository = AccountRepositoryImpl.getRepository();
    }

    public static AccountService getService() {
        if(service == null) service = new AccountServiceImpl();
        return service;
    }

    @Override
    public Set<Account> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Account create(Account account) {
        return this.repository.create(account);
    }

    @Override
    public Account read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Account update(Account account) {
        return this.update(account);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
