package com.vn.restdemo.dto;

import lombok.Data;

import java.util.List;

@Data
public class LeadDetailDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private List<ConsultantDetailDTO> consultantList;
}
