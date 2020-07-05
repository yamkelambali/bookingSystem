package com.startup.factory;

import com.startup.entity.Receptionist;
import com.startup.util.GenericHelper;

/**
 * @author Anati Jack
 * desc: Factory for receptionist
 */

public class ReceptionistFactory {

    public static Receptionist createReceptionist(String qualification){
        String receptionistID = GenericHelper.generateID();
        Receptionist receptionist = new Receptionist.Builder()
                .setAdminId(receptionistID)
                .setQualification(qualification)
                .build();
        return receptionist;
    }
}
