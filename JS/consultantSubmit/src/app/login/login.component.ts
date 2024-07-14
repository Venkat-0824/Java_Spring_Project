import { Component, OnInit } from '@angular/core';
import { UserdetailsService } from '../userdetails.service';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email:string ="";
  password:string = "";
 
  loginSuccess:boolean | undefined;

  constructor(private userDetailsService: UserdetailsService,private authservice:AuthService,private router:Router) { }

  ngOnInit() {
     
  }
  islogin:boolean=false;
  
  login(){

    this.userDetailsService.users.email = this.email;
    this.userDetailsService.users.password = this.password;

    // this.userDetailsService.details.userName = this.email;
    // this.userDetailsService.details.password = this.password;

    // for (let index = 0; index < this.userDetailsService.userData.length; index++) {
    //   console.log(this.userDetailsService.userData)
    //   if(this.email===this.userDetailsService.userData[index].email && this.password===this.userDetailsService.userData[index].password ){
    //     this.loginSuccess=true;
    //     this.authservice.login();
    //     this.router.navigate(['/home'])


    //   }
      
      
      
      
   //}

  // this.userDetailsService.getUser().forEach(item =>console.log(item));
  this.userDetailsService.checkUser().subscribe(
    response => {
     if(response) 
     // Log the response to the console
     this.islogin=response;
     
     if(this.islogin){
      this.userDetailsService.getUser(this.userDetailsService.users.email).subscribe(
        response => {
          if (response) {
            this.userDetailsService.users=response;
            
          }
        },
        error => {
          console.error('Error retrieving user information:', error);
        }
      );
      console.log(response);
     this.authservice.login();
     this.router.navigate(['/home'])
     }

    },
    error => {
      console.error(error); 
    }
  );


  }


}
