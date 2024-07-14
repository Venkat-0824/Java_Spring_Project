import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'; 

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { ProfileComponent } from './profile/profile.component';
import { LoginComponent } from './login/login.component';
import { NavigationComponent } from './navigation/navigation.component';
import { SignupComponent } from './signup/signup.component';
import { HomeComponent } from './home/home.component';
import { MaincontentComponent } from './maincontent/maincontent.component';
import { AddSubmissionComponent } from './add-submission/add-submission.component';
import { EditComponent } from './edit/edit.component';
import { StudentManagerComponent } from './student-manager/student-manager.component';



@NgModule({
  declarations: [																	
    AppComponent,
      HeaderComponent,
      ProfileComponent,
      LoginComponent,
      NavigationComponent,
      SignupComponent,
      HomeComponent,
      MaincontentComponent,
      AddSubmissionComponent,
      EditComponent,
      StudentManagerComponent
   ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
