package com.startup.controller;

import com.startup.entity.Account;
import com.startup.factory.AccountFactory;
import com.startup.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountServiceImpl accountService;

    @PostMapping("/create")
    public Account create(@RequestBody Account account){
        Account newAccount = AccountFactory.createAccount(account.getName(), account.getSurname(), account.getUsername(), account.getPassword(), account.getCellNo());
        return accountService.create(newAccount);
    }

    @GetMapping("/read/{username}")
    public Account read(@PathVariable String username){ return  accountService.read(username); }

    @PostMapping("/update")
    public Account update(@RequestBody Account account) { return accountService.update(account); }

    @GetMapping("/all")
    public Set<Account> getAll(){
        return accountService.getAll();
    }

    @DeleteMapping("/delete/{username}")
    public boolean delete(@PathVariable String username) { return accountService.delete(username); }

}
