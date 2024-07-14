import { Component, OnInit } from '@angular/core';
import { UserdetailsService } from '../userdetails.service';
import { Router } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {


    constructor(private userDetailsService: UserdetailsService,private router:Router) { }
  
    ngOnInit() {
    }
  
    details = {
      firstName: '',
      lastName: '',
      email: '',
      password: '',
      role:''
    };

    string!: string;
  
    signUp() {
      console.log(this.details.firstName);
      // this.userDetailsService.addUserDetails(this.firstName, this.lastName, this.email, this.password);

    this.userDetailsService.users.email = this.details.email;
    this.userDetailsService.users.password = this.details.password;
    this.userDetailsService.users.firstName = this.details.firstName;
    this.userDetailsService.users.lastName = this.details.lastName;
    this.userDetailsService.users.role = this.details.role;
    this.userDetailsService.users.id=0; 
    this.userDetailsService.users.leadId=0

    this.userDetailsService.addUser().subscribe(
      response => {
       if(response) 
       // Log the response to the console
       alert("user added SuccesFully")
       this.router.navigate(['/login']);
      },
      error => {
        console.error(error); // Log any errors to the console
      }
    );

      
    }
  }


