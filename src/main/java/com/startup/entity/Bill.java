package com.startup.entity;
/**
 * @author Yamkela Mbali
 * desc : Entity for User
 */
public class Bill {

    private String billNo, appointId, patientId, amount;

    private Bill(Builder builder){
        this.billNo = builder.billNo;
        this.appointId = builder.appointId;
        this.patientId = builder.patientId;
        this.amount = builder.amount;
    }

    public String getBillNo() {
        return billNo;
    }

    public String getAppointId() {
        return appointId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billNo='" + billNo + '\'' +
                ", appointId='" + appointId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }

    public static class Builder {
        private String billNo, appointId, patientId, amount;

        public Builder setBillNo(String billNo){
            this.billNo = billNo;
            return this;
        }

        public Builder setAppointId(String appointId){
            this.appointId = appointId;
            return this;
        }

        public Builder setPatientId(String patientId){
            this.patientId = patientId;
            return this;
        }
        public Builder setAmount(String amount){
            this.amount = amount;
            return this;
        }

        public Builder copy(Bill bill){
            this.billNo = bill.billNo;
            this.appointId = bill.appointId;
            this.patientId = bill.patientId;
            this.amount = bill.amount;
            return this;
        }

        public Bill build(){
            return new Bill (this);
        }
    }
}