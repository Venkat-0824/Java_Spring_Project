package com.vn.restdemo.repo;

import com.vn.restdemo.model.SubmissionDTO;

import java.util.*;

import lombok.Data;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
@Repository
public class SubmissionRepoClass implements SubmissionRepository {

    private  Map<String, SubmissionDTO> submissions = new HashMap<>();

    @Override
    public SubmissionDTO getSubmission(String id) {

        return submissions.get(id);
    }

    @Override
    public List<SubmissionDTO> getAll() {
        return new ArrayList<>(submissions.values());
    }

    @Override
    public SubmissionDTO addSubmission(SubmissionDTO submission) {
        String id = UUID.randomUUID().toString();
        submission.setId(id);

        submissions.put(id, submission);
        return submission;
    }

    @Override
    public SubmissionDTO updateSubmission(SubmissionDTO submission) {
        String id = submission.getId();
        if (submissions.containsKey(id)) {
            submissions.put(id, submission);
            return submission;
        }
        return null;
    }

    @Override
    public boolean deleteSubmission(String id) {


         submissions.entrySet().stream().filter(es -> {
            if(es.getValue().getConsultantName().equals(id)){
                return true;
            }
            return false;
        }).map(k -> k.getKey()).toList().forEach(submissions::remove);



        return true;
    }
}