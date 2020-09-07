package com.startup.service.impl;

/**
 * @author Lene Prinsloo.
 * desc : Service for Doctor
 */

import com.startup.entity.Doctor;
import com.startup.service.IService;

import java.util.Set;

public interface DoctorService extends IService<Doctor, String> {
    Set<Doctor> getAll();
}
