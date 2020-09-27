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

import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class DoctorControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private static Doctor doctor;
    private String baseURL = "http://localhost:8080/doctor";

    @Test
    public void a_create() {
        Doctor newDoctor = DoctorFactory.createDoctor("Harding0411", "Dermatology", "Dermatologists");
        String url = baseURL + "/create";

        ResponseEntity<Doctor> postResponse = restTemplate.postForEntity(url, newDoctor, Doctor.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println(postResponse);
        System.out.println(postResponse.getBody());
    }

    @Test
    public void b_read(){
        String id = doctor.getDocId();
        String url = baseURL + "/read" + id;

        ResponseEntity <Doctor> getResponse = restTemplate.getForEntity(url, Doctor.class);

        assertNotNull(getResponse.getBody());

        System.out.println(getResponse);
        System.out.println(getResponse.getBody());
    }

    @Test
    public void c_update(){
        String url = baseURL + "/update";
        String oldDept = doctor.getDept();
        doctor = new Doctor.Builder().copy(doctor).setDept("Radiology").build();
        restTemplate.put(url, doctor );

        assertNotEquals(doctor.getDept(), oldDept);
    }

    @Test
    public void e_delete(){
        String url = baseURL + "/delete/" + doctor.getDocId();
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