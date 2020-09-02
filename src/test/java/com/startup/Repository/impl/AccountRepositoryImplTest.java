package com.startup.Repository.impl;

import com.startup.entity.Account;
import com.startup.factory.AccountFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountRepositoryImplTest {
    private static AccountRepository repository = AccountRepositoryImpl.getRepository();
    private static Account account = AccountFactory.createAccount("John", "Wick", "BoogieMan", "123","123");



    @Test
    public void a_create() {
        Account created = repository.create(account);
        Assert.assertEquals(account.getUsername(), created.getUsername());
        System.out.println("Create:  " + created);
    }

    @Test
    public void b_read() {
        Account read = repository.read(account.getUsername());
        System.out.println("Read:  " + read);
    }

    @Test
    public void c_update() {
        Account updated = new Account.Builder().copy(account).setName("Tony").setSurname("Stark").setPassword("Avenger").setCellNo("321").build();
        updated = repository.update(updated);
        System.out.println("Update:  " + updated);
    }

    @Test
    public void d_delete() {
        boolean deleted = repository.delete(account.getUsername());
        Assert.assertTrue(deleted);
    }

    @Test
    public void e_getAll() {
        System.out.println("Get all - " + repository.getAll());
    }
}