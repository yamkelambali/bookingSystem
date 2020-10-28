package com.startup.service.impl;

import com.startup.Repository.impl.PatientRepository;
import com.startup.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Lene Prinsloo.
 * desc : ServiceImpl for PatientService
 */

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository repository;

    @Override
    public Set<Patient> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Patient create(Patient patient) {
        return this.repository.save(patient);
    }

    @Override
    public Patient read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Patient update(Patient patient) {
        return this.repository.save(patient);
    }

    @Override
    public boolean delete(String s) {

        this.repository.deleteById(s);
        if (this.repository.existsById(s))
            return false;
        else
            return true;

    }
}
