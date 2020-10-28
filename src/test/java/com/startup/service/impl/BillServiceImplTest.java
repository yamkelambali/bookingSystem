package com.startup.service.impl;

import com.startup.entity.Bill;
import com.startup.factory.BillFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BillServiceImplTest {

    @Autowired
    private static BillService service;
    private static Bill bill = BillFactory.generateBill("120456", "54778888", "1500");

    @Test
    public void d_getAll() {
        Set<Bill>bills = service.getAll();
        assertEquals(1, bills.size());
        System.out.println("All: " + bills);
    }

    @Test
    public void a_create() {
        Bill created = service.create(bill);
        Assert.assertEquals(bill.getBillNo(), created.getBillNo());
        System.out.println("Create bill:  " + created);
    }

    @Test
    public void b_read() {
        Bill read = service.read(bill.getBillNo());
        System.out.println("Read bill:  " + read);
    }

    @Test
    public void c_update() {
        Bill updated = new Bill.Builder().copy(bill).setAppointId("125485").setPatientId("542136582").setAmount("R399.00").build();
        updated = service.update(updated);
        System.out.println("Update:  " + updated);
    }

    @Test
    public void e_delete() {
        boolean deleted = service.delete(bill.getBillNo());
        Assert.assertTrue(deleted);
    }


}
