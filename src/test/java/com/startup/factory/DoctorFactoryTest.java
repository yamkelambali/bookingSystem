package com.startup.factory;

import com.startup.entity.Doctor;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Lene Prinsloo
 * desc : factory test class for Doctor
 */

public class DoctorFactoryTest {

    @Test
    public void createDoctor() {
        Doctor doctor = DoctorFactory.createDoctor("Harding0411", "Dermatology", "Dermatologists");
        Assert.assertNotNull(doctor);
    }
}