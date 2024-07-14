package com.vn.restdemo.entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data

public class LeadDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String phoneNumber;

    @OneToMany(mappedBy="leadDetail", cascade = CascadeType.ALL)
    private List<ConsultantDetail> consultantList;
}

