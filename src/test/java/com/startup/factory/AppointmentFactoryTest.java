package com.startup.factory;

import com.startup.entity.Appointment;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Lene Prinsloo
 * desc : factory test class for Appointment
 */

public class AppointmentFactoryTest {

    @Test
    public void createAppointment() {

        Appointment appointment = AppointmentFactory.createAppointment("0706CP071401", "CP071401", "Harding0411", "07/06/2020", "15:30:00");
        Assert.assertNotNull(appointment);
    }
}