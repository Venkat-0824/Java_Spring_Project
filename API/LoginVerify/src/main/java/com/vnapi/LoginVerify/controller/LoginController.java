package com.vnapi.LoginVerify.controller;


//import com.vnapi.loginCheck.service.LoginService;
import com.vnapi.LoginVerify.model.Submission;
import com.vnapi.LoginVerify.model.User;
import com.vnapi.LoginVerify.service.LoginService;
import com.vnapi.LoginVerify.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    List<User> l=new ArrayList();


    @Autowired
  private LoginService loginService;

    @Autowired
    public SubmissionService submissionService;

    @GetMapping(path = "/getAll")
    public List<Submission> getSubmissions(){
        List<Submission> l= submissionService.getAllSubmissions();



        return l;
    }

    @PostMapping(path = "/addSubmission")
    public boolean addSubmission(@RequestBody Submission s){
        submissionService.createSubmission(s);
        return true;
    }

    @PostMapping(path="/editSubmission")
    public Submission editSubmission(@RequestBody Submission s){
        return submissionService.updateSubmission(s.getId(),s);
    }

    @PostMapping(path="/editUser")
    public User editUser(@RequestBody User u){
        return loginService.updateUser(u.getId(),u);
    }

    @DeleteMapping(path="/delSubmission/{id}")
    public void delSubmission(@PathVariable Long id){
         submissionService.deleteSubmission(id);

    }

    @GetMapping(path = "/getUser")
    public User getDetails(String email){
        User u = loginService.getLoginByEmail(email);



        return u;
    }

    @GetMapping(path = "/getAllUsers")
    public List<User> getAllUsers(){




        return loginService.getAllUsers();
    }

    @PostMapping(path = "/checkUser")
    public boolean checkDetails(@RequestBody User details) {
        boolean result = false;
        User user1 = loginService.getLoginByEmail(details.getEmail());

            if (user1!=null && user1.getPassword().equals(details.getPassword()) ){
                result = true;
            }






        return result;
    }
    @PostMapping(path = "/addUser")

    public boolean addUser(@RequestBody User details) {

        loginService.createLogin(details);

        return true;
    }








}

