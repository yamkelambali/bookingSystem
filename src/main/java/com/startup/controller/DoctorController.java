package com.startup.controller;

/**
 * @author Lene Prinsloo
 * desc : Controller for Doctor
 */

import com.startup.entity.Doctor;
import com.startup.factory.DoctorFactory;
import com.startup.service.impl.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    public DoctorServiceImpl doctorService;

    @PostMapping("/create")
    public Doctor create(@RequestBody Doctor doctor){
        Doctor newDoctor = DoctorFactory.createDoctor(
                doctor.getDocId(),
                doctor.getDept(),
                doctor.getSpecialisation());

        return doctorService.create(newDoctor);
    }

    @GetMapping("/read/{id}")
    public Doctor read(@PathVariable String id){
        return doctorService.read(id);
    }

    @PutMapping("/update")
    public Doctor update(@RequestBody Doctor doctor){
        return doctorService.update(doctor);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        doctorService.delete(id);
    }

    @GetMapping("/all")
    public Set<Doctor> getAll(){
        return doctorService.getAll();
    }
}
