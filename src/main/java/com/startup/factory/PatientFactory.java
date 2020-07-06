package com.startup.factory;

import com.startup.entity.Patient;
import com.startup.util.GenericHelper;

/**
 * desc: Factory for patient
 */

public class PatientFactory {

    public static Patient createPatient(String historyReport, String medicalAidId){

                .setHistoryReport(historyReport)
                .setMedicalAidId(medicalAidId)
                .build();
        return patient;
    }
}
