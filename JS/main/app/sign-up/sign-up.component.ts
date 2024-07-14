import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  firstName!: string;
  lastName!: string;
  email!: string;
  password!: string;
  phone!: string;
  dob!: string;
  constructor(private router:Router,public authService: AuthService) { }

  ngOnInit() {
  }

  submitForm() {
    // Perform form submission logic here
    console.log('Form submitted');
    console.log('First Name:', this.firstName);
    console.log('Last Name:', this.lastName);
    console.log('Email:', this.email);
    console.log('Password:', this.password);
    console.log('Phone:', this.phone);
    console.log('Date of Birth:', this.dob);


    this.router.navigate(['/login']);


  }

  

}
