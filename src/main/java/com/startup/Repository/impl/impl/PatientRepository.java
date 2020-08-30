package com.startup.Repository.impl.impl;
/**
 * @author Yamkela Mbali
 */
import com.startup.Repository.impl.IRepository;
import com.startup.entity.Patient;

import java.util.Set;

public interface PatientRepository extends IRepository<Patient, String> {
    Set<Patient> getAll();
}
