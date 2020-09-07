package com.startup.service.impl;

import com.startup.Repository.impl.BillRepository;
import com.startup.Repository.impl.BillRepositoryImpl;
import com.startup.entity.Bill;

import java.util.Set;

public class BillServiceImpl implements BillService {

    private static BillService service = null;
    private BillRepository repository;

    private BillServiceImpl() {
        this.repository = BillRepositoryImpl.getRepository();
    }

    public static BillService getBill() {
        if (service == null) service = new BillServiceImpl();
        return service;
    }

    @Override
    public Set<Bill> getAll() {

        return this.repository.getAll();
    }

    @Override
    public Bill create(Bill bill) {

        return this.repository.create(bill);
    }

    @Override
    public Bill read(String a) {
        return this.repository.read(a);
    }

    @Override
    public Bill update(Bill bill) {

        return this.repository.update(bill);
    }

    @Override
    public boolean delete(String a) {

        return this.repository.delete(a);
    }

}
