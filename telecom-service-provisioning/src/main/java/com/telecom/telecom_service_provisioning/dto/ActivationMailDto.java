package com.telecom.telecom_service_provisioning.dto;

import java.time.LocalDate;

public class ActivationMailDto {
    private String email;
    private String username, subject;


    private String serviceName, serviceType;
    private String serviceBenefits, serviceDescription;
    private Double serviceCost;
    private Integer serviceValidity;

    private LocalDate startDate, endDate;

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Integer getServiceValidity() {
        return serviceValidity;
    }

    public void setServiceValidity(Integer serviceValidity) {
        this.serviceValidity = serviceValidity;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getServiceBenefits() {
        return serviceBenefits;
    }

    public void setServiceBenefits(String serviceBenefits) {
        this.serviceBenefits = serviceBenefits;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

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
}
