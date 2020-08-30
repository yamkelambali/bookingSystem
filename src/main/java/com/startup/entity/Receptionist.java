package com.startup.entity;

public class Receptionist {


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

        public Receptionist.Builder setAdminId(String adminId){
            this.adminId = adminId;
            return this;
        }

        public Receptionist.Builder setQualification(String qualification){
            this.qualification = qualification;
            return this;
        }

        public Receptionist.Builder copy(Receptionist receptionist){
            this.adminId = receptionist.adminId;
            this.qualification = qualification;
            return this;
        }

        public Receptionist build(){
            return new Receptionist (this);
        }
    }

}
