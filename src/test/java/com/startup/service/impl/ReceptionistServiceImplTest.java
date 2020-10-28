package com.startup.service.impl;
/**
 * @author Michael Bezuidenhout
 */

import com.startup.entity.Receptionist;
import com.startup.factory.ReceptionistFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReceptionistServiceImplTest {

    private static ReceptionistService service;
    private static Receptionist receptionist = ReceptionistFactory.createReceptionist("Office Administration");

    @Test
    public void d_getAll() {
        Set<Receptionist> receptionists = service.getAll();
        assertEquals(1, receptionists.size());
        System.out.println("All: " + receptionists);
    }

    @Test
    public void a_create() {
        Receptionist created = service.create(receptionist);
        Assert.assertEquals(receptionist.getAdminId(), created.getAdminId());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Receptionist read = service.read(receptionist.getAdminId());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Receptionist updated = new Receptionist.Builder().copy(receptionist).setQualification("HR Administration").build();
        updated = service.update(updated);
        System.out.println("Updated : " + updated);
    }

    @Test
    public void delete() {
        boolean deleted = service.delete(receptionist.getAdminId());
        Assert.assertTrue(deleted);
    }
}