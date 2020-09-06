package com.startup.service.impl;
/**
 * @author Yamkela Mbali
 */
import com.startup.Repository.impl.AccountRepository;
import com.startup.Repository.impl.AccountRepositoryImpl;
import com.startup.entity.Account;
import com.startup.entity.User;
import com.startup.factory.AccountFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountServiceImplTest {

    private static AccountService service = AccountServiceImpl.getService();
    private static Account account = AccountFactory.createAccount("John", "Wick", "BoogieMan", "123","123");

    @Test
    public void d_getAll() {
        Set<Account> accounts = service.getAll();
        assertEquals(  1, accounts.size());
        System.out.println( "All accounts : " + accounts);
    }

    @Test
    public void a_create() {
        Account created = service.create(account);
        Assert.assertEquals(account.getUsername(), created.getUsername());
        System.out.println("Create:  " + created);
    }

    @Test
    public void b_read() {
        Account read = service.read(account.getUsername());
        System.out.println("Read:  " + read);
    }

    @Test
    public void c_update() {
        Account updated = new Account.Builder().copy(account).setName("Tony").setSurname("Stark").setPassword("Avenger").setCellNo("321").build();
        updated = service.update(updated);
        System.out.println("Update:  " + updated);
    }

    @Test
    public void e_delete() {
        boolean deleted = service.delete(account.getUsername());
        Assert.assertTrue(deleted);
    }
}