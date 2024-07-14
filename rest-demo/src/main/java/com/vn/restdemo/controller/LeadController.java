package com.vn.restdemo.controller;

import com.vn.restdemo.dto.ConsultantDetailDTO;
import com.vn.restdemo.dto.LeadDetailDTO;
import com.vn.restdemo.dto.SubmissionDTO;
import com.vn.restdemo.entity.ConsultantDetail;
import com.vn.restdemo.entity.LeadDetail;
import com.vn.restdemo.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lead")
public class LeadController {

    @Autowired
    private LeadService service;

    @GetMapping("get/{id}")
    public ResponseEntity<LeadDetailDTO> getSubmission(@PathVariable  long id) {



        Optional<LeadDetail> response = service.getLeadDetail(id);

        if(response.isPresent())
            return ResponseEntity.status(200).body(mapToDto(response.get()));


        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);


    }

    @GetMapping("/getAll")
    public List<LeadDetailDTO> getAll(){
        List<LeadDetail> leadDetails = service.getAll();


        return leadDetails.stream().map(
                entity -> mapToDto(entity)
        ).collect(Collectors.toList());
    }


    private static LeadDetailDTO mapToDto(LeadDetail entity) {
        LeadDetailDTO dto = new LeadDetailDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmailAddress(entity.getEmailAddress());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setConsultantList(entity.getConsultantList().stream().
                map(ConsultantController::mapToDto).collect(Collectors.toList()));
        return dto;
    }

    @PostMapping(path="/add")
    public ResponseEntity<LeadDetail> addSubmission(@RequestBody LeadDetailDTO leadDetailDTO) {
        ResponseEntity<LeadDetail> re= new ResponseEntity<>(HttpStatus.CREATED);
        re=ResponseEntity.status(re.getStatusCode()).body(service.addLeadDetail(leadDetailDTO));

        return re;

    }

    @PutMapping("/update")
    public LeadDetail updateSubmission( @RequestBody LeadDetailDTO submission) {
        return  service.updateLeadDetail(submission);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSubmission(@PathVariable long id) {
        service.deleteLeadDetail(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build() ;

    }

}
