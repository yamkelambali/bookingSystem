package com.startup.service.impl;

/**
 * @author Lene Prinsloo.
 * desc : PatientServiceImplTest for PatientServiceImpl
 */

import com.startup.entity.Patient;
import com.startup.factory.PatientFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PatientServiceImplTest {

    private static PatientService service = PatientServiceImpl.getService();
    private static Patient patient = PatientFactory.createPatient("0706CP071401", "Upcoming Appointment: CP071401, Harding0411, Dermatologist, 07/06/2020, 15:30:00", "2001200220032004");

    @Test
    public void d_getAll() {
        Set<Patient> patients = service.getAll();
        assertEquals(1, patients.size());
        System.out.println("All Patients: " + service);
    }

    @Test
    public void a_create() {
        Patient createdPatient = service.create(patient);
        Assert.assertEquals(patient.getPatientId(), createdPatient.getPatientId());
        System.out.println("Create: " + createdPatient);
    }

    @Test
    public void b_read() {
        Patient read = service.read(patient.getPatientId());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Patient patientsUpdated = new Patient.Builder().copy(patient).setPatientId("0102LP1495").setHistoryReport("Upcoming Appointment: none").setMedicalAidId("2001200220032004").build();
        patientsUpdated = service.update(patientsUpdated);
        System.out.println("Update: " + patientsUpdated);
    }

    @Test
    public void e_delete() {
        boolean deleted = service.delete(patient.getPatientId());
        Assert.assertTrue(deleted);
    }
}