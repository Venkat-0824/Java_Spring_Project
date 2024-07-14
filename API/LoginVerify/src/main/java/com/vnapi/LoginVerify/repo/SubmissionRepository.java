package com.vnapi.LoginVerify.repo;


import com.vnapi.LoginVerify.model.Submission;
import com.vnapi.LoginVerify.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    // You can add custom methods for specific queries or operations
    // if needed. Spring Data JPA provides many convenient methods
    // out-of-the-box, so you may not need to define any custom methods
    // .


}