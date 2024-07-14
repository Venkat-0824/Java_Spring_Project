import { Injectable } from '@angular/core';
import { CanActivate, CanDeactivate, Router } from '@angular/router';
import { AuthService } from './auth.service';
import { ProfileComponent } from './profile/profile.component';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate, CanDeactivate<ProfileComponent> {
  constructor(private authService: AuthService, private router: Router) {}

  canActivate(): boolean {
    if (this.authService.isLoggedIn) {
      return true;
    } else {
      this.router.navigate(['/login']);
      return false;
    }
  }

  canDeactivate(component: ProfileComponent): boolean {
    return confirm('Your changes will be lost. Are you sure you want to navigate away?');
  }
}
