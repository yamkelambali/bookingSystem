package com.startup.Repository.impl;


import com.startup.Repository.AppointmentRepository;
import com.startup.entity.Appointment;
import com.startup.factory.AppointmentFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.time.LocalDate;
import java.time.LocalTime;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppointmentRepositoryImplTest {

    private static AppointmentRepository repository = AppointmentRepositoryImpl.getRepository();
    private static Appointment appointment = AppointmentFactory.createAppointment("0706CP071401", "CP071401", "Harding0411", LocalDate.of(2020,8,25), LocalTime.of(15,0) );

    @Test
    public void a_create() {
        Appointment created = repository.create(appointment);
        Assert.assertEquals(appointment.getAppointID(), created.getAppointID());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Appointment read  = repository.read(appointment.getAppointID());
        System.out.println("Read : " + read);
    }

    @Test
    public void c_update() {
        Appointment updated = new Appointment.Builder().copy(appointment).setPatientNo("Genera Practice").setDocID("General Practitioner").build();
        updated = repository.update(updated);
        System.out.println("Updated : " + updated);
    }

    @Test
    public void e_delete() {
        boolean deleted = repository.delete(appointment.getAppointID());
        System.out.println("Delete : " + deleted);
    }

    @Test
    public void d_getAll() {

        System.out.println("Get all : " + repository.getAll());
    }
}