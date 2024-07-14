import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserdetailsService } from '../userdetails.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  childVisible:boolean = false;
  childVisible2:boolean = false;

  constructor(private router:Router,public userDService:UserdetailsService) { }

  submit(){
         this.router.navigate(['home/submission'])
  }

  openChild(){
      this.childVisible=true;
      this.childVisible2=false;
  }
  openChild2(){
    this.childVisible2=true;
    this.childVisible=false;
  }


  ngOnInit() {
  }

}
