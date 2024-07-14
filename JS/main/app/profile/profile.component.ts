import { Component, OnInit } from '@angular/core';
import {SignUpComponent} from '../sign-up/sign-up.component'
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  fn='vn';
    ln='pasumarthi';
    dob='24-08-2000';
    gender='male';
    email='naveen.p';
    password: String = "sruhaei";
    isLoggedIn: boolean = false;

  constructor(private router: Router, private authService: AuthService) { 
    

  }

 
  ngOnInit() {
  }

  
    
    

}
