package com.vn.restdemo.dto;

import lombok.Data;

@Data
public class SubmissionDTO {
    private long id;
    private long consultantId;
    private String submissionDate;
    private String vendorCompany;
    private String vendorName;
    private String vendorEmailAddress;
    private String vendorPhoneNumber;
    private String implementationPartner;
    private String clientName;
    private int payRate;
    private String submissionStatus;
    private String submissionType;
    private String city;
    private String state;
    private String zip;
}
