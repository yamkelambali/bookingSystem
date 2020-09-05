
package com.startup.Repository.impl;

import com.startup.Repository.IRepository;
import com.startup.entity.Receptionist;

import java.util.Set;

public interface ReceptionistRepository extends IRepository<Receptionist, String> {
    Set<Receptionist> getAll();
}
