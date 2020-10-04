package com.startup.controller;

/**
 * @author Lene Prinsloo
 * desc : Controller for Patient
 */

import com.startup.entity.Patient;
import com.startup.factory.PatientFactory;
import com.startup.service.impl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    public PatientServiceImpl patientService;

    @PostMapping("/create")
    public Patient create(@RequestBody Patient patient){
        Patient newPatient = PatientFactory.createPatient(
          patient.getPatientId(),
          patient.getHistoryReport(),
          patient.getMedicalAidId());

        return patientService.create(newPatient);
    }

    @GetMapping("/read/{id}")
    public Patient read(@PathVariable String id){
        return patientService.read(id);
    }

    @PutMapping("/update")
    public Patient update(@RequestBody Patient patient){
        return patientService.update(patient);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {

        return patientService.delete(id);
    }

    @GetMapping("/all")
    public Set<Patient> getAll(){
        return patientService.getAll();
    }

}
