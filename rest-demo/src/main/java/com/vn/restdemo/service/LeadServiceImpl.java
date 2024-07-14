package com.vn.restdemo.service;

import com.vn.restdemo.dto.LeadDetailDTO;
import com.vn.restdemo.entity.LeadDetail;
import com.vn.restdemo.repo.LeadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeadServiceImpl implements LeadService{

    @Autowired
    private LeadRepo repository;
    @Override
    public Optional<LeadDetail> getLeadDetail(long id) {
        return  repository.findById(id);
    }

    @Override
    public LeadDetail addLeadDetail(LeadDetailDTO leadDetailDTO) {
        LeadDetail ld = new LeadDetail();
        ld.setEmailAddress(leadDetailDTO.getEmailAddress());
        ld.setPhoneNumber(leadDetailDTO.getPhoneNumber());
        ld.setFirstName(leadDetailDTO.getFirstName());
        ld.setLastName(leadDetailDTO.getLastName());
        return  repository.save(ld) ;
    }

    @Override
    public LeadDetail updateLeadDetail(LeadDetailDTO leadDetail) {
        Optional<LeadDetail> existingLeadDetail = repository.findById(leadDetail.getId());
        if (existingLeadDetail.isPresent()) {
            LeadDetail updatedLeadDetail = existingLeadDetail.get();
            updatedLeadDetail.setFirstName(leadDetail.getFirstName());
            updatedLeadDetail.setLastName(leadDetail.getLastName());
            updatedLeadDetail.setEmailAddress(leadDetail.getEmailAddress());
            updatedLeadDetail.setPhoneNumber(leadDetail.getPhoneNumber());

            return repository.save(updatedLeadDetail);
        }
        return null;
    }

    @Override
    public void deleteLeadDetail(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<LeadDetail> getAll() {
        return repository.findAll();
    }
}
