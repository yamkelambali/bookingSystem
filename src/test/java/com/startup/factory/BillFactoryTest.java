package com.startup.factory;

import com.startup.entity.Bill;
import org.junit.Test;

import static org.junit.Assert.*;

public class BillFactoryTest {

    @Test
    public void generateBill() {
        Bill bill = BillFactory.generateBill("120456", "54778888", "1500");
        assertNotNull(bill);
    }
}