package com.startup.factory;

import com.startup.entity.Appointment;

/**
 * @author Lene Prinsloo
 * desc : factory class for Appointment
 */

public class AppointmentFactory {

    public static Appointment createAppointment(String appointID, String patientNo, String docID, String appointDate, String appointTime){

        Appointment appointment = new Appointment.Builder()
                .setAppointID(appointID)
                .setPatientNo(patientNo)
                .setDocID(docID)
                .setAppointDate(appointDate)
                .setAppointTime(appointTime)
                .build();

                return appointment;

    }
}
