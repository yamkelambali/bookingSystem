//package com.startup.Repository.impl;
///**
// * @author Yamkela Mbali
// */
//import com.startup.entity.Patient;
//import com.startup.factory.PatientFactory;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class PatientRepositoryImplTest {
//    private static PatientRepository repository = PatientRepositoryImpl.getRepository();
//    private static Patient patient = PatientFactory.createPatient("0706CP071401", "Upcoming Appointment: CP071401, Harding0411, Dermatologist, 07/06/2020, 15:30:00", "2001200220032004");
//
//    @Test
//    public void a_create() {
//        Patient created = repository.create(patient);
//        Assert.assertEquals(patient.getPatientId(), created.getPatientId());
//        System.out.println("Created: " + created);
//    }
//
//    @Test
//    public void b_read() {
//        Patient read  = repository.read(patient.getPatientId());
//        System.out.println("Read : " + read);
//    }
//
//    @Test
//    public void c_update() {
//        Patient updated = new Patient.Builder().copy(patient).setMedicalAidId("2001200220032555").build();
//        updated = repository.update(updated);
//        System.out.println("Updated : " + updated);
//    }
//
//    @Test
//    public void e_delete() {
//        boolean deleted = repository.delete(patient.getPatientId());
//        Assert.assertTrue(deleted);
//    }
//
//    @Test
//    public void d_getAll() {
//        System.out.println("Get all : " + repository.getAll());
//    }
//}