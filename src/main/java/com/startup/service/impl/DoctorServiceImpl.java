package com.startup.service.impl;

import com.startup.Repository.impl.DoctorRepository;
import com.startup.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Lene Prinsloo.
 * desc : ServiceImpl for DoctorService
 */

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private DoctorRepository repository;

    @Override
    public Set<Doctor> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Doctor create(Doctor doctor) {
        return this.repository.save(doctor);
    }

    @Override
    public Doctor read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Doctor update(Doctor doctor) {

        if (this.repository.existsById(doctor.getDocId())) {
            return this.repository.save(doctor);
        }
        return null;
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
