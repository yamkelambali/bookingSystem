package com.startup.Repository.impl;

import com.startup.Repository.ReceptionistRepository;
import com.startup.entity.Receptionist;

import java.util.HashSet;
import java.util.Set;
/*
  * @author Anati Jack
   */

public class ReceptionistRepositoryImpl implements ReceptionistRepository {

    private static ReceptionistRepository repository = null;
    private Set<Receptionist> receptionistDB;

    private ReceptionistRepositoryImpl() { this.receptionistDB = new HashSet<>();

    }

    public static ReceptionistRepository getRepository(){
        if (repository == null) repository = new ReceptionistRepositoryImpl();
        return repository;
    }

    @Override
    public Receptionist create(Receptionist receptionist) {
        this.receptionistDB.add(receptionist);
        return receptionist;
    }

    @Override
    public Receptionist read(String adminId) {
        for (Receptionist receptionist : this.receptionistDB){
            if (receptionist.getAdminId().equalsIgnoreCase(adminId))
                return receptionist;
        }
        return null;
    }

    @Override
    public Receptionist update(Receptionist receptionist) {
        boolean deleteReceptionist = delete(receptionist.getAdminId());
        if(deleteReceptionist){
            this.receptionistDB.add(receptionist);
            return receptionist;
        }
        return null;
    }

    @Override
    public boolean delete(String adminId) {
        Receptionist receptionist= read(adminId);
        if(adminId !=null){
            this.receptionistDB.remove(receptionist);
        }
        return false;
    }

    @Override
    public Set<Receptionist> getAll() {
        return null;
    }

}
