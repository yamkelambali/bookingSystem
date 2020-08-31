package com.startup.Repository.impl;

import com.startup.entity.Bill;
import com.startup.factory.BillFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BillRepositoryImplTest {

    private static BillRepository repository = BillRepositoryImpl.getRepository();
    private static Bill bill = BillFactory.generateBill("123455", "1122", "R499.95");


    @Test
    public void a_create() {
        Bill created = repository.create(bill);
        Assert.assertEquals(bill.getBillNo(), created.getBillNo());
        System.out.println("Create:  " + created);
    }

    @Test
    public void b_read() {
        Bill read = repository.read(bill.getBillNo());
        System.out.println("Read:  " + read);
    }

    @Test
    public void c_update() {
        Bill updated = new Bill.Builder().copy(bill).setAmount("R399.00").build();
        updated = repository.update(updated);
        System.out.println("Update:  " + updated);
    }

    @Test
    public void d_delete() {
        boolean deleted = repository.delete(bill.getBillNo());
        Assert.assertTrue(deleted);
    }

    @Test
    public void e_getAll() {
        System.out.println("Get all:  " + repository.getAll());
    }
}