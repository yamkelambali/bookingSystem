package com.startup.entity;

import java.io.Serializable;

/**
 * @author Lene Prinsloo
 * desc : Entity for Patient
 */

public class Patient implements Serializable {

    private String patientId, historyReport, medicalAidId;

    private Patient(){}

    private Patient(Builder builder){
        this.patientId = builder.patientId;
        this.historyReport = builder.historyReport;
        this.medicalAidId = builder.medicalAidId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getHistoryReport() {
        return historyReport;
    }

    public String getMedicalAidId() {
        return medicalAidId;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId='" + patientId + '\'' +
                ", historyReport='" + historyReport + '\'' +
                ", medicalAidId='" + medicalAidId + '\'' +
                '}';
    }

    public static class Builder{
        private  String patientId, historyReport, medicalAidId;

        public Builder setPatientId(String patientId){
            this.patientId = patientId;
            return this;
        }

        public Builder setHistoryReport(String historyReport){
            this.historyReport = historyReport;
            return this;
        }

        public Builder setMedicalAidId(String medicalAidId){
            this.medicalAidId = medicalAidId;
            return this;
        }

        public Patient.Builder copy(Patient patient){
            this.patientId = patient.patientId;
            this.historyReport = patient.historyReport;
            this.medicalAidId = patient.medicalAidId;
            return this;
        }

        public Patient build(){
            return new Patient (this);
        }
    }

}
