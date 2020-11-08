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

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PatientControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/bookingSystem/patient/";


    private static Patient patient = PatientFactory.createPatient("0706CP071401", "Upcoming Appointment: CP071401, Harding0411, Dermatologist, 07/06/2020, 15:30:00", "2001200220032004");
    private static String SECURITY_USERNAME = "client";
    private static String SECURITY_PASSWORD = "kkdmmc";
    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL: " + url);
        System.out.println("Post Data: " + patient);

        ResponseEntity<Patient> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, patient, Patient.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        patient = postResponse.getBody();
        System.out.println("Saved Data: " + patient);
        assertEquals(patient.getPatientId(), postResponse.getBody().getPatientId());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + patient.getPatientId();
        System.out.println("URL: " + url);

        ResponseEntity<Patient> getResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Patient.class);

        assertEquals(patient.getPatientId(), getResponse.getBody().getPatientId());
        System.out.println(getResponse.getBody());
    }

    @Test
    public void c_update() {
        Patient updatePatient = new Patient.Builder().copy(patient).setPatientId("0706CP071495").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);

        System.out.println("Post Data: " + updatePatient);
        ResponseEntity<Patient> postResponse = restTemplate.postForEntity(url, updatePatient, Patient.class);
        assertEquals(patient.getPatientId(), postResponse.getBody().getPatientId());
    }

    @Test
    public void e_delete() {
        String url = baseURL + "/delete/" + patient.getPatientId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    public void d_getAll() {
        String url = baseURL + "all";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(response);
        System.out.println(response.getBody());
    }
}