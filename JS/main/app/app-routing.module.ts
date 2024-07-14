import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { ProfileComponent } from './profile/profile.component';
import { AuthGuard } from './auth.guard';


const routes: Routes = [
 {path:'login' ,component:LoginComponent} ,
 {path:'signup' ,component:SignUpComponent} ,
 {path:'profile' ,component:ProfileComponent,canActivate:[AuthGuard],canDeactivate:[AuthGuard]} ,


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [AuthGuard]
})
export class AppRoutingModule { }
