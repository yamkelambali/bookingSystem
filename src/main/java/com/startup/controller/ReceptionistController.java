package com.startup.controller;

import com.startup.entity.Receptionist;
import com.startup.factory.ReceptionistFactory;
import com.startup.service.impl.ReceptionistService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/receptionist")
public class ReceptionistController {

    @Autowired
    private ReceptionistService receptionistService;

    @PostMapping("/create")
    public Receptionist create (@RequestBody Receptionist receptionist){
        Receptionist newReceptionist = ReceptionistFactory.createReceptionist(receptionist.getQualification());
        return receptionistService.create(newReceptionist);

    }
    @GetMapping("/all")
    public Set<Receptionist> getAll()
    {
        return receptionistService.getAll();
    }

    @GetMapping("/read/{id}")
    public Receptionist read(@PathVariable String id){
        return receptionistService.read(id);
    }

    @PostMapping ("/update")
    public Receptionist update(@RequestBody Receptionist receptionist){
        return receptionistService.update(receptionist);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return receptionistService.delete(id);
    }
}
