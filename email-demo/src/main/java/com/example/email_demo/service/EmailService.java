package com.example.email_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.example.email_demo.Dto.ActivationMailDto;
import com.example.email_demo.Dto.RegistrationMailDto;
import com.example.email_demo.Dto.TerminationMailDto;

import jakarta.mail.internet.MimeMessage;


@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public void sendRegistrationMail(RegistrationMailDto registrationMailDto) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,"UTF-8");
            helper.setFrom("telcoservice.helpdesk@gmail.com");

            // Load Thymeleaf template
            Context context = new Context();
            java.util.Map<String, Object> templateModel = new java.util.HashMap<>();
            templateModel.put("dto", registrationMailDto);
            context.setVariables(templateModel);  // Inject dynamic data into the template
            String html = templateEngine.process("Regi", context);

            helper.setTo(registrationMailDto.getEmail());
            helper.setSubject(registrationMailDto.getSubject());
            helper.setText(html, true);

            javaMailSender.send(message);
        } catch (Exception e) {
            System.err.println("Failed to send registration email: " + e.getMessage());
        }
    }

    public void sendActivationMail(ActivationMailDto activationMailDto) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,"UTF-8");
            helper.setFrom("telcoservice.helpdesk@gmail.com");

            // Load Thymeleaf template
            Context context = new Context();
            java.util.Map<String, Object> templateModel = new java.util.HashMap<>();
            templateModel.put("dto", activationMailDto);
            context.setVariables(templateModel);  // Inject dynamic data into the template
            String html = templateEngine.process("ServiceActivation", context);

            helper.setTo(activationMailDto.getEmail());
            helper.setSubject(activationMailDto.getSubject());
            helper.setText(html, true);

            javaMailSender.send(message);
        } catch (Exception e) {
            System.err.println("Failed to send registration email: " + e.getMessage());
        }
    }

    public void sendTerminationMail(TerminationMailDto terminationMailDto) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,"UTF-8");
            helper.setFrom("telcoservice.helpdesk@gmail.com");

            // Load Thymeleaf template
            Context context = new Context();
            java.util.Map<String, Object> templateModel = new java.util.HashMap<>();
            templateModel.put("dto", terminationMailDto);
            context.setVariables(templateModel);  // Inject dynamic data into the template
            String html = templateEngine.process("ServiceTermination", context);

            helper.setTo(terminationMailDto.email);
            helper.setSubject(terminationMailDto.subject);
            helper.setText(html, true);

            javaMailSender.send(message);
        } catch (Exception e) {
            System.err.println("Failed to send registration email: " + e.getMessage());
        }
    }
}
