
package com.startup.Repository;

import com.startup.entity.Receptionist;

import java.util.Set;

public interface ReceptionistRepository extends IRepository<Receptionist, String> {
    Set<Receptionist> getAll();
}
