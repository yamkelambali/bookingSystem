package com.startup.factory;

import com.startup.entity.Patient;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PatientFactoryTest {

    @Test
    public void createPatient(){

        Patient patient = PatientFactory.createPatient("0706CP071401", "Upcoming Appointment: CP071401, Harding0411, Dermatologist, 07/06/2020, 15:30:00", "2001200220032004");
        Assert.assertNotNull(patient);

    }

}