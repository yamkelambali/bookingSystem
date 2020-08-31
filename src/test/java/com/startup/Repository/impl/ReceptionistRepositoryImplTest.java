package com.startup.Repository.impl;

import com.startup.Repository.ReceptionistRepository;
import com.startup.entity.Receptionist;
import com.startup.factory.ReceptionistFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReceptionistRepositoryImplTest {

    private static ReceptionistRepository repository = ReceptionistRepositoryImpl.getRepository();
    private static Receptionist receptionist = ReceptionistFactory.createReceptionist( "Office Administration");

    @Test
    public void a_create() {
        Receptionist created = repository.create(receptionist);
        Assert.assertEquals(receptionist.getAdminId(), created.getAdminId());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Receptionist read  = repository.read(receptionist.getAdminId());
        System.out.println("Read : " + read);
    }

    @Test
    public void c_update() {
        Receptionist updated = new Receptionist.Builder().copy(receptionist).setQualification("Genera Practice").build();
        updated = repository.update(updated);
        System.out.println("Updated : " + updated);
    }

    @Test
    public void e_delete() {
        boolean deleted = repository.delete(receptionist.getAdminId());
        System.out.println("Deleted : " + deleted);
    }

    @Test
    public void d_getAll() {

        System.out.println("Get all : " + repository.getAll());
    }


}

