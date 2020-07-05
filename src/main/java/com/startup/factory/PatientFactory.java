package com.startup.factory;

import com.startup.entity.Patient;
import com.startup.util.GenericHelper;

/**
 * @author Anati Jack
 * desc: Factory for patient
 */

public class PatientFactory {

    public static Patient createPatient(String historyReport, String medicalAidId){
        String patientID = GenericHelper.generateID();
        Patient patient = new Patient.Builder()
                .setPatientId(patientID)
                .setHistoryReport(historyReport)
                .setMedicalAidId(medicalAidId)
                .build();
        return patient;
    }
}
