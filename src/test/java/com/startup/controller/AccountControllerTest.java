package com.startup.controller;

import com.startup.entity.Account;
import com.startup.entity.User;
import com.startup.factory.AccountFactory;
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
public class AccountControllerTest {

    private static Account account = AccountFactory.createAccount("Tony", "Stark", "BoogieMan", "123", "123");
    private static String SECURITY_USERNAME = "lene";
    private static String SECURITY_PASSWORD = "password";

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/account/";

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL" + url);
        System.out.println("POST data: " + account);
        ResponseEntity<Account> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, account, Account.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        account = postResponse.getBody();
        System.out.println("Saved data: " + account);
        assertEquals(account.getUsername(), postResponse.getBody().getUsername());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + account.getUsername();
        System.out.println("URL: " + url);
        ResponseEntity<Account> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Account.class);
        assertEquals(account.getUsername(), response.getBody().getUsername());
    }

    @Test
    public void c_update() {
        Account updatedAccount = new Account.Builder().copy(account).setName("John").setSurname("Wick").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Updated details: " + updatedAccount);
        ResponseEntity<Account> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, updatedAccount, Account.class);
        assertEquals(account.getUsername(), response.getBody().getUsername());
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

    @Test
    public void e_delete() {
        String url = baseURL + "delete/" + account.getUsername();
        System.out.println("URL: " + url);
        restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);
    }
}