package com.startup.service.impl;

/**
 * @author Lene Prinsloo.
 * desc : Service for Patient
 */

import com.startup.entity.Patient;
import com.startup.service.IService;
import java.util.Set;

public interface PatientService extends IService<Patient, String> {
    Set<Patient> getAll();
}
