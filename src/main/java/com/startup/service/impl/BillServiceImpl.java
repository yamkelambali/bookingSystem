package com.startup.service.impl;

import com.startup.Repository.impl.BillRepository;
import com.startup.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository repository;

    @Override
    public Set<Bill> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Bill create(Bill bill) {
        return this.repository.save(bill);
    }

    @Override
    public Bill read(String a) {
        return this.repository.findById(a).orElse(null);
    }

    @Override
    public Bill update(Bill bill) {
        if (this.repository.existsById(bill.getBillNo())) {
            return this.repository.save(bill);
        }
        return null;
    }

    @Override
    public boolean delete(String a) {
        this.repository.deleteById(a);
        if (this.repository.existsById(a)) return false;
        else return true;
    }

}
