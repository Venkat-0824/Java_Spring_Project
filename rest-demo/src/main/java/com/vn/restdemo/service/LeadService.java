package com.vn.restdemo.service;

import com.vn.restdemo.dto.LeadDetailDTO;
import com.vn.restdemo.entity.LeadDetail;
import com.vn.restdemo.entity.Submission;

import java.util.List;
import java.util.Optional;

public interface LeadService {

    Optional<LeadDetail> getLeadDetail(long id);

    LeadDetail addLeadDetail(LeadDetailDTO submission);

    LeadDetail updateLeadDetail(LeadDetailDTO submission);

    void deleteLeadDetail(long id);


    List<LeadDetail> getAll();
}
