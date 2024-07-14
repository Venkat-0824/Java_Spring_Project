package com.vnapi.LoginVerify.model;

import jakarta.persistence.*;

@Entity
@Table(name = "submission")
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private String date;

    @Column(name = "consultant_name")
    private String consultantName;

    @Column(name = "technology")
    private String technology;

    @Column(name = "leads")
    private String leads;

    @Column(name = "sales_person")
    private String salesPerson;

    @Column(name = "vendor_name")
    private String vendorName;

    @Column(name = "rate")
    private int rate;

    // Constructors, getters, and setters

    // Other methods

    public Submission() {
    }

    public Submission(String date, String consultantName, String technology, String leads, String salesPerson, String vendorName, int rate) {
        this.date = date;
        this.consultantName = consultantName;
        this.technology = technology;
        this.leads = leads;
        this.salesPerson = salesPerson;
        this.vendorName = vendorName;
        this.rate = rate;
    }

    // Getters and setters omitted for brevity


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getConsultantName() {
        return consultantName;
    }

    public void setConsultantName(String consultantName) {
        this.consultantName = consultantName;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getLeads() {
        return leads;
    }

    public void setLead(String leads) {
        this.leads = leads;
    }

    public String getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(String salesPerson) {
        this.salesPerson = salesPerson;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Submission{" +
                ", date='" + date + '\'' +
                ", consultantName='" + consultantName + '\'' +
                ", technology='" + technology + '\'' +
                ", lead='" + leads + '\'' +
                ", salesPerson='" + salesPerson + '\'' +
                ", vendorName='" + vendorName + '\'' +
                ", rate=" + rate +
                '}';
    }
}

