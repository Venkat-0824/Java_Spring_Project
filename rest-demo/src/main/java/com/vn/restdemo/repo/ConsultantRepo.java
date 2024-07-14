package com.vn.restdemo.repo;

import com.vn.restdemo.entity.ConsultantDetail;
import com.vn.restdemo.entity.LeadDetail;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Function;

@Repository
public interface ConsultantRepo extends JpaRepository<ConsultantDetail,Long> {


   List<ConsultantDetail> findByFirstName(String firstName);


//   List<ConsultantDetail> findAllByFirstName(Iterable<String> names);
}
