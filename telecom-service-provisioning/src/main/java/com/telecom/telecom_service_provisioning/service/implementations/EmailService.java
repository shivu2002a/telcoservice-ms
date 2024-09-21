package com.telecom.telecom_service_provisioning.service.implementations;

import com.telecom.telecom_service_provisioning.dto.ActivationMailDto;
import com.telecom.telecom_service_provisioning.dto.RegistrationMailDto;
import com.telecom.telecom_service_provisioning.dto.TerminationMailDto;
import com.telecom.telecom_service_provisioning.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class EmailService {

    @Autowired
    private RestTemplate restTemplate;

    public static final String MAILSERVICE_URL = "http://spring-cloud-gateway/api/email";
    public static final String REGISTRATION_SUBJECT = "Registered on Telcoservice";

    public void sendRegistrationMail(User user) {
        RegistrationMailDto dto = new RegistrationMailDto();
        dto.setEmail(user.getEmail());
        dto.setAddress(user.getAddress());
        dto.setSubject(REGISTRATION_SUBJECT);
        dto.setUsername(user.getUsername());
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<Object> entity = new HttpEntity<>(dto, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(MAILSERVICE_URL + "/registration-mail", entity, String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            LOGGER.info("Registration mail successfully sent to User : {}", user.getUsername());
        } else {
            LOGGER.error("Registration mail couldn't be sent; {}", response.getBody());
        }
    }

    public void sendServiceActivationMail(ActivationMailDto dto) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<Object> entity = new HttpEntity<>(dto, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(MAILSERVICE_URL + "/activation-mail", entity, String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            LOGGER.info("Service subscribed mail successfully sent to User : {}", dto.getUsername());
        } else {
            LOGGER.error("Subcribed mail couldn't be sent; {}", response.getBody());
        }
    }

    public void sendServiceTerminationMail(TerminationMailDto dto) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<Object> entity = new HttpEntity<>(dto, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(MAILSERVICE_URL + "/termination-mail", entity, String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            LOGGER.info("Service termination mail successfully sent to User : {}", dto.getUsername());
        } else {
            LOGGER.error("Registration mail couldn't be sent; {}", response.getBody());
        }
    }
}
