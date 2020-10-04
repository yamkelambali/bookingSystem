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
    public Receptionist a_create (@RequestBody Receptionist receptionist){
        Receptionist newReceptionist = ReceptionistFactory.createReceptionist(receptionist.getAdminId());
        return receptionistService.create(newReceptionist);

    }
    @GetMapping("/all")
    public Set<Receptionist> d_getAll()
    {
        return receptionistService.getAll();
    }

    @GetMapping("/read/{id}")
    public Receptionist b_read(@PathVariable String id){
        return receptionistService.read(id);
    }

    @PostMapping ("/update")
    public Receptionist c_update(@RequestBody Receptionist receptionist){
        return receptionistService.update(receptionist);
    }

    @DeleteMapping("/delete/{id}")
    public boolean e_delete(@PathVariable String id){
        return receptionistService.delete(id);
    }
}
