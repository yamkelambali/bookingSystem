package com.startup.factory;

import com.startup.entity.Receptionist;
import org.junit.Assert;
import org.junit.Test;


public class ReceptionistFactoryTest {


    @Test
    public void createReceptionist(){


        Receptionist receptionist = ReceptionistFactory.createReceptionist( "Office Administration");
        Assert.assertNotNull(receptionist);
    }
}

