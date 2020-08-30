package com.startup.Repository.impl.impl;
/**
 * @author Yamkela Mbali
 */
import com.startup.Repository.impl.IRepository;
import com.startup.entity.Doctor;

import java.util.Set;

public interface DoctorRepository extends IRepository<Doctor, String> {

    Set<Doctor> getAll();
}
