package com.startup.entity;

import java.io.Serializable;

/**
 * @author Lene Prinsloo
 * desc : Entity for Doctor
 */

public class Doctor implements Serializable {

    private String docId, dept, specialisation;

    private Doctor(){}

    private Doctor(Builder builder){
        this.docId = builder.docId;
        this.dept = builder.dept;
        this.specialisation = builder.specialisation;
    }

    public String getDocId() {
        return docId;
    }

    public String getDept() {
        return dept;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "docID='" + docId + '\'' +
                ", dept='" + dept + '\'' +
                ", specialisation= '" + specialisation + '\'' +
                '}';
    }

    public static class Builder{

        private String docId, dept, specialisation;

        public Builder setDoctorId(String docId){
            this.docId = docId;
            return this;
        }

        public Builder setDept(String dept){
            this.dept = dept;
            return this;
        }
        public Builder setSpecialisation(String specialisation){
            this.specialisation = specialisation;
            return this;
        }

        public Builder copy(Doctor doctor){
            this.docId = doctor.docId;
            this.dept = doctor.dept;
            this.specialisation = doctor.specialisation;

            return this;
        }

        public Doctor build(){ return new Doctor(this);}
    }
}
