package com.startup.controller;

/**
 * @author Lene Prinsloo
 * desc : Test for DoctorController
 */

import com.startup.entity.Doctor;
import com.startup.factory.DoctorFactory;
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
public class DoctorControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/bookingSystem/doctor/";

    private static Doctor doctor = DoctorFactory.createDoctor("Harding0411", "Dermatology", "Dermatologists");
    private static String SECURITY_USERNAME = "client";
    private static String SECURITY_PASSWORD = "kkdmmc";
    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL: " + url);
        System.out.println("Post Data: " + doctor);

        ResponseEntity<Doctor> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, doctor, Doctor.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        doctor = postResponse.getBody();
        System.out.println("Saved Data: " + doctor);
        assertEquals(doctor.getDocId(), postResponse.getBody().getDocId());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + doctor.getDocId();
        System.out.println("URL: " + url);

        ResponseEntity<Doctor> getResponse = restTemplate.getForEntity(url, Doctor.class);

        assertEquals(doctor.getDocId(), getResponse.getBody().getDocId());
        System.out.println(getResponse.getBody());
    }

    @Test
    public void c_update() {
        Doctor updateDoctor = new Doctor.Builder().copy(doctor).setDept("Radiology").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);

        System.out.println("Post Data: " + updateDoctor);
        ResponseEntity<Doctor> postResponse = restTemplate.postForEntity(url, updateDoctor, Doctor.class);
        assertEquals(doctor.getDept(), postResponse.getBody().getDept());
    }

    @Test
    public void e_delete() {
        String url = baseURL + "delete/" + doctor.getDocId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);

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