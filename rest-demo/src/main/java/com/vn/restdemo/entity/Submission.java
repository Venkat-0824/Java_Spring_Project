package com.vn.restdemo.entity;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "submission")
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="consultant_id")
    private ConsultantDetail consultantDetail;

//    @Column(name = "consultant_id")
//    private long consultantId;

    @Column(name = "submission_date")
    private String submissionDate;

    @Column(name = "vendor_company", length = 50)
    private String vendorCompany;

    @Column(name = "vendor_name", length = 80)
    private String vendorName;

    @Column(name = "vendor_email_address", length = 100)
    private String vendorEmailAddress;

    @Column(name = "vendor_phone_number", length = 20)
    private String vendorPhoneNumber;

    @Column(name = "implementation_partner", length = 50)
    private String implementationPartner;

    @Column(name = "client_name", length = 80)
    private String clientName;

    @Column(name = "pay_rate")
    private int payRate;

    @Column(name = "submission_status", length = 20)
    private String submissionStatus;

    @Column(name = "submission_type", length = 20)
    private String submissionType;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "state", length = 50)
    private String state;

    @Column(name = "zip", length = 10)
    private String zip;

    // Constructors, getters, setters, and other methods

}

