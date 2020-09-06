package com.startup.factory;

import com.startup.entity.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserFactoryTest {

    @Test
    public void createUser() {

        User user = UserFactory.createUser("AsongeD", "@song3", "Asonge", "Dyosini", "0670860456", "AsongeD@gmail.com");
        Assert.assertNotNull(user);

    }
}