package com.telecom.telecom_service_provisioning.dto;

import java.time.LocalDate;

public class TerminationMailDto {
    public String email;
    public String username, subject;

    public String serviceName, serviceType;
    public Integer serviceValidity;

    public LocalDate startDate, endDate;

    public Integer noOfDaysUsed;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getServiceValidity() {
        return serviceValidity;
    }

    public void setServiceValidity(Integer serviceValidity) {
        this.serviceValidity = serviceValidity;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getNoOfDaysUsed() {
        return noOfDaysUsed;
    }

    public void setNoOfDaysUsed(Integer noOfDaysUsed) {
        this.noOfDaysUsed = noOfDaysUsed;
    }
}
