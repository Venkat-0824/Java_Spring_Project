import { Component, OnInit } from '@angular/core';
import { UserdetailsService } from '../userdetails.service';
import { User } from '../user';

@Component({
  selector: 'app-student-manager',
  templateUrl: './student-manager.component.html',
  styleUrls: ['./student-manager.component.css']
})
export class StudentManagerComponent implements OnInit {

  constructor(public usd:UserdetailsService) { }



  ngOnInit() {
    this.usd.getAll()
    .subscribe( response => {
      if(response) 
      
      this.usd.userInfo=response;
    
     
    });
  }
  addTo(ud:User){
   ud.leadId=this.usd.users.id;
   
   this.usd.editUser(ud).subscribe(
    response => {
     if(response) 
     // Log the response to the console
    alert('Added Succesfull')
    
    },
    error => {
      console.error(error); // Log any errors to the console
    }
  );

  }
  removeFrom(ud:User){
    ud.leadId=0;
   
   this.usd.editUser(ud).subscribe(
    response => {
     if(response) 
     // Log the response to the console
    alert('Removal Succesfull')
    
    },
    error => {
      console.error(error); // Log any errors to the console
    }
  );

  }

}
