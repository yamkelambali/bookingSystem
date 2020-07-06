package com.startup.factory;

import com.startup.entity.Patient;
import com.startup.util.GenericHelper;

/**
 * @author Anti Jack
 * desc: Factory for patient
 */

public class PatientFactory {

    public static Patient createPatient(String historyReport, String medicalAidId){
        String patientId = GenericHelper.generateId();
        Patient patient = new Patient.Builder()
                .setPatientId(patientId)
                .setHistoryReport(historyReport)
                .setMedicalAidId(medicalAidId)
                .build();
        return patient;
    }
}
