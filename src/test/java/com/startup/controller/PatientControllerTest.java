package com.startup.controller;

/**
 * @author Lene Prinsloo
 * desc : Test for PatientController
 */

import com.startup.entity.Patient;
import com.startup.factory.PatientFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class PatientControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private static Patient patient;
    private String baseURL = "http://localhost:8080/patient";

    @Test
    public void a_create() {
        Patient newPatient = PatientFactory.createPatient("0706CP071401", "Upcoming Appointment: CP071401, Harding0411, Dermatologist, 07/06/2020, 15:30:00", "2001200220032004");
        String url = baseURL + "/create";

        ResponseEntity<Patient> postResponse = restTemplate.postForEntity(url, newPatient, Patient.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println(postResponse);
        System.out.println(postResponse.getBody());
    }

    @Test
    public void b_read() {
        String id = patient.getPatientId();
        String url = baseURL + "/read" + id;

        ResponseEntity <Patient> getResponse = restTemplate.getForEntity(url, Patient.class);

        assertNotNull(getResponse.getBody());

        System.out.println(getResponse);
        System.out.println(getResponse.getBody());
    }

    @Test
    public void c_update() {
        String url = baseURL + "/update";
        String wrongPatientId = patient.getPatientId();
        patient = new Patient.Builder().copy(patient).setPatientId("0706CP071495").build();
        restTemplate.put(url, patient);

        assertNotEquals(patient.getPatientId(), wrongPatientId);
    }

    @Test
    public void e_delete() {
        String url = baseURL + "/delete/" + patient.getPatientId();
        restTemplate.delete(url);

        ResponseEntity <List> response = restTemplate.getForEntity(baseURL + "/all", List.class);

        System.out.println(response.getBody());
        System.out.println(response.getStatusCode());
    }

    @Test
    public void d_getAll() {
        String url = baseURL + "all";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(response);
        System.out.println(response.getBody());
    }
}