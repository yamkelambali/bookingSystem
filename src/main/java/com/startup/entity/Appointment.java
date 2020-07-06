package com.startup.entity;

import java.util.*;

/**
 * @author Lene Prinsloo
 * desc : Entity for Appointment
 */

public class Appointment {

    private String appointID, patientNo, docID, appointDate, appointTime;

    private Appointment(Builder builder){
        this.appointID = builder.appointID;
        this.patientNo = builder.patientNo;
        this.docID = builder.docID;
        this.appointDate = builder.appointDate;
        this.appointTime = builder.appointTime;
    }

    public String getAppointID(){ return appointID;}

    public String getPatientNo(){ return patientNo;}

    public String getDocID(){ return docID;}

    public String getAppointDate(){ return appointDate;}

    public String getAppointTime(){ return appointTime;}

    @Override
    public String toString(){
        return "Appointments{" +
                "appointID='" + appointID + '\'' +
                ", patientNo='" + patientNo + '\'' +
                ", docID='" + docID + '\'' +
                ", appointDate='" + appointDate + '\'' +
                ", appointTime='" + appointTime + '\'' +
                '}';
    }

    public static class Builder{
        private String appointID, patientNo, docID, appointDate, appointTime;

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

        public Builder setAppointDate(String appointDate){

            this.appointDate = appointDate;
            return this;
        }

        public Builder setAppointTime(String appointTime){

            this.appointTime = appointTime;
            return this;
        }

        public Builder copy(Appointment appointment){
            this.appointID = appointment.appointID;
            this.patientNo = appointment.patientNo;
            this.docID = appointment.docID;
            this.appointDate = appointment.appointDate;
            this.appointTime = appointment.appointTime;
            return this;
        }
        public Appointment build(){
            return new Appointment (this);
        }

    }

}
