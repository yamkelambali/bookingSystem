package com.startup.service.impl;

import com.startup.Repository.impl.AccountRepositoryImpl;
import com.startup.Repository.impl.DoctorRepository;
import com.startup.Repository.impl.DoctorRepositoryImpl;
import com.startup.entity.Doctor;

import java.util.Set;

/**
 * @author Lene Prinsloo.
 * desc : ServiceImpl for DoctorService
 */

public class DoctorServiceImpl implements DoctorService{

    private static DoctorService service = null;
    private DoctorRepository repository;

    private DoctorServiceImpl() {
        this.repository = DoctorRepositoryImpl.getRepository();
    }

    public static DoctorService getService(){
        if(service == null) service = new DoctorServiceImpl();
        return service;
    }

    @Override
    public Set<Doctor> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Doctor create(Doctor doctor) {
        return this.repository.create(doctor);
    }

    @Override
    public Doctor read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Doctor update(Doctor doctor) {
        return this.repository.update(doctor);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }

}
