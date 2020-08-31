package com.startup.Repository.impl;
/**
 * @author Yamkela Mbali
 */
import com.startup.Repository.DoctorRepository;
import com.startup.entity.Doctor;
import com.startup.factory.DoctorFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DoctorRepositoryImplTest {

    private static DoctorRepository repository = DoctorRepositoryImpl.getRepository();
    private static Doctor doctor = DoctorFactory.createDoctor("Harding0411", "Dermatology", "Dermatologists");

    @Test
    public void a_create() {
        Doctor created = repository.create(doctor);
        Assert.assertEquals(doctor.getDocId(), created.getDocId());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Doctor read  = repository.read(doctor.getDocId());
        System.out.println("Read : " + read);
    }

    @Test
    public void c_update() {
        Doctor updated = new Doctor.Builder().copy(doctor).setDept("Genera Practice").setSpecialisation("General Practitioner").build();
        updated = repository.update(updated);
        System.out.println("Updated : " + updated);
    }

    @Test
    public void e_delete() {
        boolean deleted = repository.delete(doctor.getDocId());
        Assert.assertTrue(deleted);

    }

    @Test
    public void d_getAll() {
        System.out.println("Get all : " + repository.getAll());
    }
}