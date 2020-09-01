package com.startup.factory;

import com.startup.entity.Appointment;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Lene Prinsloo
 * desc : factory class for Appointment
 */

public class AppointmentFactory {

    public static Appointment createAppointment(String appointID, String patientNo, String docID, LocalDate localDate, LocalTime localTime){

        Appointment appointment = new Appointment.Builder()
                .setAppointID(appointID)
                .setPatientNo(patientNo)
                .setDocID(docID)
                .setLocalDate(localDate)
                .setLocalTime(localTime)
                .build();

                return appointment;

    }
}