package com.startup.factory;

import com.startup.entity.Account;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountFactoryTest {

    @Test
    public void createAccount() {
        Account account = AccountFactory.createAccount("John", "Doe", "JD", "AbC123!", "1234567890");
        assertNotNull(account);
    }
}