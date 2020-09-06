package com.startup.service.impl;

import com.startup.Repository.impl.PatientRepository;
import com.startup.Repository.impl.PatientRepositoryImpl;
import com.startup.entity.Patient;

import java.util.Set;

/**
 * @author Lene Prinsloo
 * desc : ServiceImpl for PatientService
 */

public class PatientServiceImpl implements PatientService{

    private static PatientService service = null;
    private PatientRepository repository;

    private PatientServiceImpl() {
        this.repository = PatientRepositoryImpl.getRepository();
    }

    public static PatientService getService() {
        if(service == null) service = new PatientServiceImpl();
        return service;
    }

    @Override
    public Set<Patient> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Patient create(Patient patient) {
        return this.repository.create(patient);
    }

    @Override
    public Patient read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Patient update(Patient patient) {
        return this.repository.update(patient);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
