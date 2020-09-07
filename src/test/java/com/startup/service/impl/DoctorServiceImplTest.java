package com.startup.service.impl;

/**
 * @author Lene Prinsloo.
 * desc : DoctorServiceImplTest for DoctorServiceImpl
 */

import com.startup.entity.Doctor;
import com.startup.factory.DoctorFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DoctorServiceImplTest {

    private static DoctorService service = DoctorServiceImpl.getService();
    private static Doctor doctor = DoctorFactory.createDoctor("Harding0411", "Dermatology", "Dermatologists");

    @Test
    public void d_getAll() {
        Set<Doctor> doctors = service.getAll();
        assertEquals(1, doctors.size());
        System.out.println("All Doctors: " + service);
    }

    @Test
    public void a_create() {
        Doctor createDoctor = service.create(doctor);
        Assert.assertEquals(doctor.getDocId(), createDoctor.getDocId());
        System.out.println("Create: " + createDoctor);
    }

    @Test
    public void b_read() {
        Doctor read = service.read(doctor.getDocId());
        System.out.println("Read: " +read);
    }

    @Test
    public void c_update() {
        Doctor doctorsUpdated = new Doctor.Builder().copy(doctor).setDoctorId("Lippert3005").setDept("Dietetics").setSpecialisation("Dietitians").build();
        doctorsUpdated = service.update(doctorsUpdated);
        System.out.println("Update: "+ doctorsUpdated);
    }

    @Test
    public void e_delete() {
        boolean deleted = service.delete(doctor.getDocId());
        Assert.assertTrue(deleted);
    }
}