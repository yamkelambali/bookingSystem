package com.startup.factory;

import com.startup.entity.Appointment;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Lene Prinsloo
 * desc : factory test class for Appointment
 */

public class AppointmentFactoryTest {

    @Test
    public void createAppointment() {
        Appointment appointment = AppointmentFactory.createAppointment("0706CP071401", "CP071401", "Harding0411", LocalDate.of(2020,8,25), LocalTime.of(15,0) );
        Assert.assertNotNull(appointment);
    }

}