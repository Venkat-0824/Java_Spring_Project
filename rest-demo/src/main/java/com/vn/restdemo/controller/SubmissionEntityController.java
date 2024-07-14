package com.vn.restdemo.controller;

import com.vn.restdemo.dto.ConsultantDetailDTO;
import com.vn.restdemo.entity.ConsultantDetail;
import com.vn.restdemo.entity.Submission;
import com.vn.restdemo.dto.SubmissionDTO;
import com.vn.restdemo.service.SubmissionEntityService;
import com.vn.restdemo.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/submit")
public class SubmissionEntityController {

    @Autowired
    private SubmissionEntityService submissionService;

    @GetMapping("get/{id}")
    public ResponseEntity<SubmissionDTO> getSubmission(@PathVariable  long id) {

        Optional<Submission> response = submissionService.getSubmission(id);

        if(response.isPresent())
        return ResponseEntity.status(200).body(mapToDto(response.get()));


        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);


    }

    @GetMapping("/getAll")
    public List<SubmissionDTO> getAll(){
        return submissionService.getAll().stream().map(SubmissionEntityController::mapToDto).toList();
    }

    @PostMapping(path="/add")
    public ResponseEntity<SubmissionDTO> addSubmission(@RequestBody SubmissionDTO submission) {
        ResponseEntity<SubmissionDTO> re= new ResponseEntity<>(HttpStatus.CREATED);
        re=ResponseEntity.status(re.getStatusCode()).body(mapToDto(submissionService.addSubmission(submission)));

        return re;

    }

    public static SubmissionDTO mapToDto(Submission submissionDetail){
        SubmissionDTO sDto = new SubmissionDTO();
        sDto.setId(submissionDetail.getId());
        sDto.setConsultantId(submissionDetail.getConsultantDetail().getId());
        sDto.setSubmissionDate(submissionDetail.getSubmissionDate());
        sDto.setVendorCompany(submissionDetail.getVendorCompany());
        sDto.setVendorName(submissionDetail.getVendorName());
        sDto.setVendorEmailAddress(submissionDetail.getVendorEmailAddress());
        sDto.setVendorPhoneNumber(submissionDetail.getVendorPhoneNumber());
        sDto.setImplementationPartner(submissionDetail.getImplementationPartner());
        sDto.setClientName(submissionDetail.getClientName());
        sDto.setPayRate(submissionDetail.getPayRate());
        sDto.setSubmissionStatus(submissionDetail.getSubmissionStatus());
        sDto.setSubmissionType(submissionDetail.getSubmissionType());
        sDto.setCity(submissionDetail.getCity());
        sDto.setState(submissionDetail.getState());
        sDto.setZip(submissionDetail.getZip());
        return sDto;
    }

    @PutMapping("/update")
    public Submission updateSubmission( @RequestBody Submission submission) {
        return  submissionService.updateSubmission(submission);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSubmission(@PathVariable long id) {
        submissionService.deleteSubmission(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null) ;

    }

}
