package com.startup.service.impl;

import com.startup.Repository.impl.AppointmentRepository;
import com.startup.Repository.impl.AppointmentRepositoryImpl;
import com.startup.entity.Appointment;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author Michael Bezuidenhout
 */

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private static AppointmentService service = null;
    private AppointmentRepository repository;

    private AppointmentServiceImpl() {
        this.repository = AppointmentRepositoryImpl.getRepository();
    }

    public static AppointmentService getService() {
        if (service == null) service = new AppointmentServiceImpl();
        return service;
    }

    @Override
    public Set<Appointment> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Appointment create(Appointment appointment) {
        return this.repository.create(appointment);
    }

    @Override
    public Appointment read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Appointment update(Appointment appointment) {
        return this.repository.update(appointment);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
