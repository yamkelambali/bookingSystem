package com.startup.entity;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Lene Prinsloo
 * desc : Entity for Appointment
 */

public class Appointment {

    private String appointID, patientNo, docID;
    private LocalDate localDate;
    private LocalTime localTime;

    public Appointment(Builder builder){
        this.appointID = builder.appointID;
        this.patientNo = builder.patientNo;
        this.docID = builder.docID;
        this.localDate = builder.localDate;
        this.localTime = builder.localTime;
    }

    public String getAppointID(){ return appointID;}

    public String getPatientNo(){ return patientNo;}

    public String getDocID(){ return docID;}

    public LocalDate getLocalDate(){ return localDate;}

    public LocalTime getLocalTime(){ return localTime;}


    @Override
    public String toString(){
        return "Appointments{" +
                "appointID='" + appointID + '\'' +
                ", patientNo='" + patientNo + '\'' +
                ", docID='" + docID + '\'' +
                ", appointDate='" + localDate + '\'' +
                ", localTime='" + localTime + '\'' +
                '}';
    }

    public static class Builder{
        private String appointID, patientNo, docID;
        private LocalDate localDate;
        private LocalTime localTime;

        public Builder setAppointID(String appointID){

            this.appointID = appointID;
            return  this;
        }

        public Builder setPatientNo(String patientNo){

            this.patientNo = patientNo;
            return this;
        }

        public Builder setDocID(String docID){

            this.docID = docID;
            return this;
        }

        public Builder setLocalDate(LocalDate localDate){

            this.localDate = localDate;
            return this;
        }

        public Builder setLocalTime(LocalTime localTime){

            this.localTime = localTime;
            return this;
        }


        public Builder copy(Appointment appointment){
            this.appointID = appointment.appointID;
            this.patientNo = appointment.patientNo;
            this.docID = appointment.docID;
            this.localDate = appointment.localDate;
            this.localTime = appointment.localTime;
            return this;
        }
        public Appointment build(){
            return new Appointment (this);
        }

    }

}
