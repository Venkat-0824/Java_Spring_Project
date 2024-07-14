package com.vn.restdemo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class ConsultantDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="lead_id")
    private LeadDetail leadDetail;
//    private long leadId;


    private String firstName;


    private String lastName;


    private String emailAddress;


    private String phoneNumber;

    @OneToMany(mappedBy="consultantDetail", cascade = CascadeType.ALL)
    List<Submission> submissionList;

}
