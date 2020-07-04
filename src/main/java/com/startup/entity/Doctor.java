package com.startup.entity;

public class Doctor {

    private String docId, dept, specialisation;

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
        return "Doctor Details"+
                "Doctor ID      : "+docId+ '\''+
                "Department     : "+dept+'\''+
                "Specialisation : "+specialisation+'\'';
    }

    public static class Builder{

        private String docId, dept, specialisation;

        private Builder setDoctorId(String docId){
            this.docId = docId;
            return this;
        }

        private Builder setDept(String dept){
            this.dept = dept;
            return this;
        }
        private Builder setSpecialisation(String specialisation){
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
