package com.startup.controller;

/**
@authur Anati Jack
 */

import com.startup.entity.Appointment;
import com.startup.factory.AppointmentFactory;
import com.startup.service.impl.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentServiceImpl appointmentService;

    @PostMapping("/create")
    public Appointment create (@RequestBody Appointment appointment){
        Appointment newAppointment = AppointmentFactory.createAppointment(appointment.getAppointID(), appointment.getPatientNo(), appointment.getDocID(), appointment.getLocalDate(), appointment.getLocalTime());
        return appointmentService.create(newAppointment);
    }

    @GetMapping("/all")
    public Set<Appointment> getAll(){
        return  appointmentService.getAll();
    }

    @GetMapping("/read/{id}")
    public Appointment read(@PathVariable String id){
        return appointmentService.read(id);
    }

    @PostMapping ("/update")
    public Appointment update(@RequestBody Appointment address){
        return appointmentService.update(address);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return appointmentService.delete(id);
    }
}
