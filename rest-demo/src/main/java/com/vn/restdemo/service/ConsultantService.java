package com.vn.restdemo.service;

import com.vn.restdemo.dto.ConsultantDetailDTO;
import com.vn.restdemo.entity.ConsultantDetail;

import java.util.List;
import java.util.Optional;

public interface ConsultantService {
    Optional<ConsultantDetail> getConsultantDetail(long id);

   // ConsultantDetail addConsultantDetail(ConsultantDetail consultantDetail);

    ConsultantDetail addConsultantDetail(ConsultantDetailDTO consultantDetail);

    ConsultantDetail updateConsultantDetail(ConsultantDetailDTO consultantDetail);

    void deleteConsultantDetail(long id);

    List<ConsultantDetail> getAll();
}
