package com.vn.restdemo.service;

import com.vn.restdemo.model.SubmissionDTO;

import java.util.List;

public interface SubmissionService {
    SubmissionDTO getSubmission(String id);

    SubmissionDTO addSubmission(SubmissionDTO submission);

    SubmissionDTO updateSubmission(SubmissionDTO submission);

    boolean deleteSubmission(String id);

    List<SubmissionDTO> getAll();

}
