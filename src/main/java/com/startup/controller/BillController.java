package com.startup.controller;


import com.startup.entity.Bill;
import com.startup.factory.BillFactory;
import com.startup.service.impl.BillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("Bill")
public class BillController {

    @Autowired
    public BillServiceImpl billService;

    @RequestMapping(value = "/generate")
    public Bill create(Bill bill){
        Bill newBill = BillFactory.generateBill(bill.getAmount(),bill.getPatientId(),bill.getAppointId());
        return billService.create(newBill);

        }

        public Set<Bill> getall(){
            return billService.getAll();
        }

    }

