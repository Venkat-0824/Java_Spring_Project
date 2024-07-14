import { Component, OnInit } from '@angular/core';
import { UserdetailsService } from '../userdetails.service';
import { User } from '../user';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  
  

  constructor(public userDetailsService: UserdetailsService) {
    
  }
  information={
    firstName:' ',
    lastName:' ',
    email:' ',
    password:' ',
    role:' '

  }

  ngOnInit() {
    // this.userDetailsService.getUser(this.userDetailsService.users.email).subscribe(
    //   response => {
    //     if (response) {
    //       this.userDetailsService.users=response;
    //       this.information = response;
    //     }
    //   },
    //   error => {
    //     console.error('Error retrieving user information:', error);
    //   }
    // );
  }


}
