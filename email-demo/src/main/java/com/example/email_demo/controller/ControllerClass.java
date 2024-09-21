package com.example.email_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller
 */
@Controller
public class ControllerClass {

    @GetMapping("/")
    public String home() {
        return "Regi";
    }

    @GetMapping("/activation")
    public String activation() {
        return "ServiceActivation";
    }

    @GetMapping("/termination")
    public String termination() {
        return "ServiceTermination";
    }


    
}