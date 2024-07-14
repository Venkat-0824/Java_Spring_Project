package com.vn.restdemo.dto;

import lombok.Data;

import java.util.List;

@Data
public class ConsultantDetailDTO {
    private long id;
    private long leadId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;

    private List<SubmissionDTO> submissionList;
}
