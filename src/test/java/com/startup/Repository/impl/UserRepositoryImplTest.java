package com.startup.Repository.impl;
/*
  @author Lene Prinsloo
 */
import com.startup.entity.User;
import com.startup.factory.UserFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRepositoryImplTest {

    private static UserRepository repository = UserRepositoryImpl.getRepository();
    private static User user = UserFactory.createUser("lprinsloo", "prinsloo50", "Lene", "Prinsloo", "0810488240", "prinsloolene@gmail.com");

    @Test
    public void a_create() {
        User created = repository.create(user);
        Assert.assertEquals(user.getUserId(), created.getUserId());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        User read = repository.read(user.getUserId());
        System.out.println("Read : " + read);
    }

    @Test
    public void c_update() {
        User updated = new User.Builder().copy(user).setEmailAddress("leneprinsloo@gmail.com").build();
        updated = repository.update(updated);
        System.out.println("Updated : " + updated);
    }

    @Test
    public void e_delete() {
        boolean deleted = repository.delete(user.getUserId());
        Assert.assertTrue(deleted);
    }

    @Test
    public void d_getAll() {
        System.out.println("Get all : " + repository.getAll());
    }
}