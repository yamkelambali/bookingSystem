package com.startup.Repository;
/**
 * @author Yamkela Mbali
 */
import com.startup.Repository.IRepository;
import com.startup.entity.Patient;

import java.util.Set;

public interface PatientRepository extends IRepository <Patient, String> {
    Set<Patient> getAll();
}
