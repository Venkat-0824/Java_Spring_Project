import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  loginText: string = 'Login';
  search: string = '';
  
  constructor(private router:Router,public authService: AuthService) { }

  ngOnInit() {
  }

  login(){
    
    this.router.navigate(['/login']);
    
  }

  logout(){
    this.authService.logout();
    this.router.navigate(['/login']);
    alert("Logged out succsfully")
    
  }
  signup(){
    this.router.navigate(['/signup']);
  }

  profile(){
    this.router.navigate(['/profile']);
  }

  
  

}
