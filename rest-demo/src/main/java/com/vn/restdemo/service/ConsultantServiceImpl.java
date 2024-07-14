package com.vn.restdemo.service;


import com.vn.restdemo.dto.ConsultantDetailDTO;
import com.vn.restdemo.entity.ConsultantDetail;
import com.vn.restdemo.entity.LeadDetail;
import com.vn.restdemo.repo.ConsultantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultantServiceImpl implements ConsultantService {

    @Autowired
    private  ConsultantRepo repository;

    @Override
    public Optional<ConsultantDetail> getConsultantDetail(long id) {
        Optional<ConsultantDetail> r= repository.findById(id);
        return r;
    }

    @Override
    public ConsultantDetail addConsultantDetail(ConsultantDetailDTO consultantDetail) {
        ConsultantDetail cd= new ConsultantDetail();
        cd.setFirstName(consultantDetail.getFirstName());
        cd.setLastName(consultantDetail.getLastName());
        cd.setEmailAddress(consultantDetail.getEmailAddress());
        cd.setPhoneNumber(consultantDetail.getPhoneNumber());
        cd.setLeadDetail(new LeadDetail());
        cd.getLeadDetail().setId(consultantDetail.getLeadId());
        ConsultantDetail r=repository.save(cd);
        return r;
    }

    @Override
    public ConsultantDetail updateConsultantDetail(ConsultantDetailDTO consultantDetail) {
        Optional<ConsultantDetail> existingConsultantDetail = repository.findById(consultantDetail.getId());
        if (existingConsultantDetail.isPresent()) {
            ConsultantDetail updatedConsultantDetail = existingConsultantDetail.get();
            //updatedConsultantDetail.setLeadId(consultantDetail.getLeadId());
            LeadDetail ld =new LeadDetail();
            ld.setId(consultantDetail.getLeadId());
            updatedConsultantDetail.setLeadDetail(ld);
            updatedConsultantDetail.setFirstName(consultantDetail.getFirstName());
            updatedConsultantDetail.setLastName(consultantDetail.getLastName());
            updatedConsultantDetail.setEmailAddress(consultantDetail.getEmailAddress());
            updatedConsultantDetail.setPhoneNumber(consultantDetail.getPhoneNumber());

            return repository.save(updatedConsultantDetail);
        }
        return null;
    }

    @Override
    public void deleteConsultantDetail(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ConsultantDetail> getAll() {
        return repository.findAll();
    }

    public List<ConsultantDetail> getByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }

//    public List<ConsultantDetail> getAllByFirstName(String firstName) {
//
//        return repository.findAllByFirstName(List.of(firstName));
//    }
}


