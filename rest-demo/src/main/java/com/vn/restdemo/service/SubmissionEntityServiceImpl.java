package com.vn.restdemo.service;


import com.vn.restdemo.entity.ConsultantDetail;
import com.vn.restdemo.entity.Submission;
import com.vn.restdemo.dto.SubmissionDTO;
import com.vn.restdemo.repo.SubmissionEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubmissionEntityServiceImpl implements SubmissionEntityService{

    @Autowired
    private SubmissionEntityRepo repository;
    @Override
    public Optional<Submission> getSubmission(long id) {
       return  repository.findById(id);

    }



    @Override
    public Submission addSubmission(SubmissionDTO submission) {

        Submission updatedSubmission =new Submission();
        ConsultantDetail cd = new ConsultantDetail();
        cd.setId(submission.getConsultantId());
       updatedSubmission.setConsultantDetail(cd);

        updatedSubmission.setSubmissionDate(submission.getSubmissionDate());
        updatedSubmission.setVendorCompany(submission.getVendorCompany());
        updatedSubmission.setVendorName(submission.getVendorName());
        updatedSubmission.setVendorEmailAddress(submission.getVendorEmailAddress());
        updatedSubmission.setVendorPhoneNumber(submission.getVendorPhoneNumber());
        updatedSubmission.setImplementationPartner(submission.getImplementationPartner());
        updatedSubmission.setClientName(submission.getClientName());
        updatedSubmission.setPayRate(submission.getPayRate());
        updatedSubmission.setSubmissionStatus(submission.getSubmissionStatus());
        updatedSubmission.setSubmissionType(submission.getSubmissionType());
        updatedSubmission.setCity(submission.getCity());
        updatedSubmission.setState(submission.getState());
        updatedSubmission.setZip(submission.getZip());

       return  repository.save(updatedSubmission);
    }

    @Override
    public Submission updateSubmission(Submission submission) {
        Optional<Submission> existingSubmission = repository.findById(submission.getId());
        if (existingSubmission.isPresent()) {
            Submission updatedSubmission = existingSubmission.get();
       //     updatedSubmission.setConsultantId(submission.getConsultantId());
            updatedSubmission.setConsultantDetail(submission.getConsultantDetail());
            updatedSubmission.setSubmissionDate(submission.getSubmissionDate());
            updatedSubmission.setVendorCompany(submission.getVendorCompany());
            updatedSubmission.setVendorName(submission.getVendorName());
            updatedSubmission.setVendorEmailAddress(submission.getVendorEmailAddress());
            updatedSubmission.setVendorPhoneNumber(submission.getVendorPhoneNumber());
            updatedSubmission.setImplementationPartner(submission.getImplementationPartner());
            updatedSubmission.setClientName(submission.getClientName());
            updatedSubmission.setPayRate(submission.getPayRate());
            updatedSubmission.setSubmissionStatus(submission.getSubmissionStatus());
            updatedSubmission.setSubmissionType(submission.getSubmissionType());
            updatedSubmission.setCity(submission.getCity());
            updatedSubmission.setState(submission.getState());
            updatedSubmission.setZip(submission.getZip());

            return repository.save(updatedSubmission);
        }
        return null;
    }

    @Override
    public void deleteSubmission(long id) {
        repository.deleteById(id);

    }

    @Override
    public List<Submission> getAll() {
        return repository.findAll();
    }
}
