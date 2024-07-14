package com.vnapi.LoginVerify.service;


import com.vnapi.LoginVerify.model.Submission;
import com.vnapi.LoginVerify.model.User;
import com.vnapi.LoginVerify.repo.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;



    public User getLoginByEmail(String email) {
        return loginRepository.findByEmail(email);
    }

    public User updateUser(Long id, User user) {
        Optional<User> existingUser = loginRepository.findById(id);
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setId(user.getId());
            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setLastName(user.getLastName());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setRole(user.getRole());
            updatedUser.setLeadId(user.getLeadId());
            return loginRepository.save(updatedUser);
        }
        return null; // or throw an exception indicating the submission was not found
    }

    public List<User> getAllUsers() {
        return loginRepository.findAll();
    }

    public User getLoginById(Long id) {
        return loginRepository.findById(id).orElse(null);
    }

    public User createLogin(User user) {
        return loginRepository.save(user);
    }
}

