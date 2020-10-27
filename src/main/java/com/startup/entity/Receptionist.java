package com.startup.entity;

import java.io.Serializable;

public class Receptionist implements Serializable {


    private String adminId, qualification;

    private Receptionist(Receptionist.Builder builder){
        this.adminId = builder.adminId;
        this.qualification = builder.qualification;
    }

    public String getAdminId() {
        return adminId;
    }

    public String getQualification() {
        return qualification;
    }

    @Override
    public String toString() {
        return "Receptionist{" +
                "adminId='" + adminId + '\'' +
                ", qualification='" + qualification + '\'' +
                '}';
    }

    public static class Builder{
        private  String adminId, qualification;

        public Builder setAdminId(String adminId){
            this.adminId = adminId;
            return this;
        }

        public Builder setQualification(String qualification){
            this.qualification = qualification;
            return this;
        }

        public Builder copy(Receptionist receptionist){
            this.adminId = receptionist.adminId;
            this.qualification = receptionist.qualification;
            return this;
        }

        public Receptionist build(){
            return new Receptionist (this);
        }
    }



}
