package com.startup.service.impl;

import com.startup.Repository.impl.AppointmentRepository;
import com.startup.Repository.impl.AppointmentRepositoryImpl;
import com.startup.Repository.impl.ReceptionistRepository;
import com.startup.Repository.impl.ReceptionistRepositoryImpl;
import com.startup.entity.Receptionist;

import java.util.Set;

/**
 * @author Michael Bezuidenhout
 */

public class ReceptionistServiceImpl implements  ReceptionistService{

    private static  ReceptionistService service = null;
    private ReceptionistRepository repository;

    private ReceptionistServiceImpl() {
        this.repository = ReceptionistRepositoryImpl.getRepository();
    }

    public static ReceptionistService getService() {
        if (service == null) service = new ReceptionistServiceImpl();
        return service;
    }


    @Override
    public Set<Receptionist> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Receptionist create(Receptionist receptionist) {
        return this.repository.create(receptionist);
    }

    @Override
    public Receptionist read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Receptionist update(Receptionist receptionist) {
        return this.repository.update(receptionist);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
