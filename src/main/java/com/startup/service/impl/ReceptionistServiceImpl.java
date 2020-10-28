package com.startup.service.impl;

import com.startup.Repository.impl.ReceptionistRepository;

import com.startup.entity.Receptionist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Michael Bezuidenhout
 */
@Service
public class ReceptionistServiceImpl implements  ReceptionistService{

    @Autowired
    private ReceptionistRepository repository;

    @Override
    public Set<Receptionist> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Receptionist create(Receptionist receptionist) {
        return this.repository.save(receptionist);
    }

    @Override
    public Receptionist read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Receptionist update(Receptionist receptionist) {
        if (this.repository.existsById(receptionist.getAdminId())){
            return this.repository.save(receptionist);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if (this.repository.existsById(s)) return false;
        return true;
    }
}
