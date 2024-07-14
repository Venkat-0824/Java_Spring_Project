import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProfileComponent } from './profile/profile.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { AuthGuard } from './auth.guard';
import { NavigationComponent } from './navigation/navigation.component';
import { HomeComponent } from './home/home.component';
import { MaincontentComponent } from './maincontent/maincontent.component';

const routes: Routes = [
  {path:'profile' ,component:ProfileComponent,canActivate:[AuthGuard]} ,
  {path:'login' , component:LoginComponent},
  {path:'signup',component:SignupComponent},
  
  {path:'home',component:HomeComponent,canActivate:[AuthGuard]},
  {path:'home/submissions',component:MaincontentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
