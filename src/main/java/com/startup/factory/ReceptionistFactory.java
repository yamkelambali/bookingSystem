package com.startup.factory;

import com.startup.entity.Bill;
import com.startup.entity.Receptionist;
import com.startup.util.GenericHelper;

/**
 * @author Anati Jack
 * disc: Factory for receptionist
 */

public class ReceptionistFactory {

    public static Receptionist createReceptionist(String qualification) {

        String adminId = GenericHelper.generateId();
        Receptionist receptionist = new Receptionist.Builder()
                .setAdminId(adminId)
                .setQualification(qualification)
                .build();

        return receptionist;
    }
}
