//package com.startup.Repository.impl;
//
//
//import com.startup.entity.Appointment;
//
//import java.util.HashSet;
//import java.util.Set;
//
///*
// * @author Anati Jack
// */
//
//public class AppointmentRepositoryImpl implements AppointmentRepository {
//
//    private static AppointmentRepository repository = null;
//    private Set<Appointment> appointmentDB;
//
//    private AppointmentRepositoryImpl() {
//        this.appointmentDB = new HashSet<>();
//    }
//
//    public static AppointmentRepository getRepository(){
//        if (repository == null) repository = new AppointmentRepositoryImpl();
//        return repository;
//    }
//
//    @Override
//    public Appointment create(Appointment appointment) {
//        this.appointmentDB.add(appointment);
//        return appointment;
//    }
//
//    @Override
//    public Appointment read(String appointID) {
//        for (Appointment appointment : this.appointmentDB){
//            if (appointment.getAppointID().equalsIgnoreCase(appointID))
//                return appointment;
//        }
//        return null;
//    }
//
//    @Override
//    public Appointment update(Appointment appointment) {
//        boolean deleteAppointment = delete(appointment.getAppointID());
//        if(deleteAppointment){
//            this.appointmentDB.add(appointment);
//            return appointment;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String appointID) {
//        Appointment appointment = read(appointID);
//        if(appointment !=null){
//            this.appointmentDB.remove(appointment);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Set<Appointment> getAll() {
//        return this.appointmentDB;
//    }
//}
