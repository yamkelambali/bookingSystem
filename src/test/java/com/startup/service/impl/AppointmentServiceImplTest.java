package com.startup.service.impl;
/**
 * @author Michael Bezuidenhout
 */

import com.startup.entity.Appointment;
import com.startup.factory.AppointmentFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppointmentServiceImplTest {

    private static AppointmentService service;
    private static Appointment appointment = AppointmentFactory.createAppointment("0706CP071401", "CP071401", "Harding0411", LocalDate.of(2020,8,25), LocalTime.of(15,0));

    @Test
    public void d_getAll() {
        Set<Appointment> appointments = service.getAll();
        assertEquals(1, appointments.size());
        System.out.println("All: " + service.getAll());
    }

    @Test
    public void a_create() {
        Appointment created = service.create(appointment);
        Assert.assertEquals(appointment.getAppointID(), created.getAppointID());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Appointment read = service.read(appointment.getAppointID());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Appointment updated = new Appointment.Builder().copy(appointment).setPatientNo("54").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete() {
        boolean deleted = service.delete(appointment.getAppointID());
        Assert.assertTrue(deleted);
    }
}