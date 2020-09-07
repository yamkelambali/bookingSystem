package com.startup.service.impl;
/**
 * @author Michael Bezuidenhout
 */

import com.startup.entity.Appointment;
import com.startup.service.IService;

import java.util.Set;

public interface AppointmentService extends IService<Appointment, String> {
    Set<Appointment> getAll();
}
