package com.vnapi.LoginVerify.service;

import java.util.List;
import java.util.Optional;

import com.vnapi.LoginVerify.model.Submission;
import com.vnapi.LoginVerify.repo.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmissionService {
    private final SubmissionRepository submissionRepository;

    @Autowired
    public SubmissionService(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    public List<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    public Optional<Submission> getSubmissionById(Long id) {
        return submissionRepository.findById(id);
    }

    public Submission createSubmission(Submission submission) {
        return submissionRepository.save(submission);
    }

    public Submission updateSubmission(Long id, Submission submission) {
        Optional<Submission> existingSubmission = submissionRepository.findById(id);
        if (existingSubmission.isPresent()) {
            Submission updatedSubmission = existingSubmission.get();
            updatedSubmission.setDate(submission.getDate());
            updatedSubmission.setConsultantName(submission.getConsultantName());
            updatedSubmission.setTechnology(submission.getTechnology());
            updatedSubmission.setLead(submission.getLeads());
            updatedSubmission.setSalesPerson(submission.getSalesPerson());
            updatedSubmission.setVendorName(submission.getVendorName());
            updatedSubmission.setRate(submission.getRate());
            return submissionRepository.save(updatedSubmission);
        }
        return null; // or throw an exception indicating the submission was not found
    }

    public void deleteSubmission(Long id) {
        submissionRepository.deleteById(id);
    }
}
