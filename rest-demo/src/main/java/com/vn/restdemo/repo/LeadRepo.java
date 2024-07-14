package com.vn.restdemo.repo;

import com.vn.restdemo.entity.LeadDetail;
import com.vn.restdemo.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadRepo extends JpaRepository<LeadDetail,Long> {
}
