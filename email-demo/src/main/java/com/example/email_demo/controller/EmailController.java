package com.example.email_demo.controller;

import com.example.email_demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.email_demo.Dto.ActivationMailDto;
import com.example.email_demo.Dto.RegistrationMailDto;
import com.example.email_demo.Dto.TerminationMailDto;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/check")
    public ResponseEntity<String> check() {
        return ResponseEntity.ok("Everything all right!!");
    }

    @PostMapping("/registration-mail")
    public ResponseEntity<String> sendRegistrationEmail(@RequestBody RegistrationMailDto regMailDto ) {
        emailService.sendRegistrationMail(regMailDto);
        return ResponseEntity.ok("Registration email sent successfully!");
    }

    @PostMapping("/activation-mail")
    public ResponseEntity<String> sendActivationEmail(@RequestBody ActivationMailDto activationMailDto ) {
        emailService.sendActivationMail(activationMailDto);
        return ResponseEntity.ok("Activation email sent successfully!");
    }

    @PostMapping("/termination-mail")
    public ResponseEntity<String> sendTerminationEmail(@RequestBody TerminationMailDto terminationMailDto ) {
        emailService.sendTerminationMail(terminationMailDto);
        return ResponseEntity.ok("Termination email sent successfully!");
    }
}
