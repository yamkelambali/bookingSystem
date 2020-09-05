
package com.startup.Repository.impl;

import com.startup.Repository.IRepository;
import com.startup.entity.Appointment;

import java.util.Set;

public interface AppointmentRepository extends IRepository<Appointment, String> {
    Set<Appointment> getAll();
}
