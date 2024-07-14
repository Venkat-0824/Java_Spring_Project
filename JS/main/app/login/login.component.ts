import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router,private authService: AuthService) { }

  ngOnInit() {
  }

  email!: string;
  password!: string;

  login() {
   
    console.log('Email:', this.email);
    console.log('Password:', this.password);
   

    if(
      this.email == 'prithvi2198@gmail.com' &&
      this.password == '12345'
    ){
      this.authService.login();
      alert('login Succesfull')
    }
    else{
      alert('invalid details')
    }

    


   
  }

}
