package com.vn.restdemo.controller;

import com.vn.restdemo.dto.ConsultantDetailDTO;
import com.vn.restdemo.entity.ConsultantDetail;
import com.vn.restdemo.service.ConsultantService;
import com.vn.restdemo.service.ConsultantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consultant")
public class ConsultantController {

    @Autowired
    private ConsultantServiceImpl service;

    @GetMapping("/get/{id}")
    public ResponseEntity<ConsultantDetailDTO> getConsultantDetail(@PathVariable long id) {
        Optional<ConsultantDetail> response = service.getConsultantDetail(id);

        if (response.isPresent()) {
            ConsultantDetailDTO cDto = mapToDto(response.get());
            return ResponseEntity.status(HttpStatus.OK).body(cDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }



    @GetMapping("/getAll")
    public List<ConsultantDetailDTO> getAllConsultantDetails() {

        return service.getAll().stream().map(a -> mapToDto(a)).toList();
    }



    @GetMapping("/getByName/{name}")
    public List<ConsultantDetailDTO> getAllByName(@PathVariable String name) {
        return service.getByFirstName(name).stream().map(a -> mapToDto(a)).toList();
    }

    public static ConsultantDetailDTO mapToDto(ConsultantDetail consultantDetail){
            ConsultantDetailDTO cDto = new ConsultantDetailDTO();
            cDto.setId(consultantDetail.getId());
            cDto.setLeadId(consultantDetail.getLeadDetail().getId());
            cDto.setFirstName(consultantDetail.getFirstName());
            cDto.setLastName(consultantDetail.getLastName());
            cDto.setEmailAddress(consultantDetail.getEmailAddress());
            cDto.setPhoneNumber(consultantDetail.getPhoneNumber());
            if(consultantDetail.getSubmissionList()!=null)
            cDto.setSubmissionList(consultantDetail.getSubmissionList().stream().
                    map(SubmissionEntityController::mapToDto).toList());

            return cDto;
    }

    @PostMapping("/add")
    public ResponseEntity<ConsultantDetailDTO> addConsultantDetail(@RequestBody ConsultantDetailDTO consultantDetail) {
        ConsultantDetailDTO savedConsultantDetail = mapToDto(service.addConsultantDetail(consultantDetail));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedConsultantDetail);
    }

    @PutMapping("/update")
    public ResponseEntity<ConsultantDetail> updateConsultantDetail(@RequestBody ConsultantDetailDTO consultantDetail) {
        ConsultantDetail updatedConsultantDetail = service.updateConsultantDetail(consultantDetail);
        if (updatedConsultantDetail != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedConsultantDetail);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteConsultantDetail(@PathVariable long id) {
        service.deleteConsultantDetail(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

