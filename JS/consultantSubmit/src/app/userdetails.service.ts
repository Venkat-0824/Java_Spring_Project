import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserdetailsService {

  userInfo:User[]=[]

  users: User={
    id:0,
    firstName:' ',
    lastName:' ',
    email:' ',
    password:' ',
    role:' ',
    leadId:0
  }


  
  
  
  constructor(private http: HttpClient) { 
    
  }

  public getAll(): Observable<User[]> 
  {
    const url = 'http://localhost:8080/login/getAllUsers';
 
    return this.http.get<User[]>(url);
  }

  public getUser(email:string): Observable<User> 
  {
    const url = `http://localhost:8080/login/getUser?email=${email}`;
 
    return this.http.get<User>(url);
  }

  public checkUser(): Observable<boolean> {
    const url = 'http://localhost:8080/login/checkUser';
    this.users.firstName=' ';
    this.users.lastName=' ';
  
    return this.http.post<boolean>(url, this.users);
  }

  public editUser(s:User):Observable<User>{
    return this.http.post<User>('http://localhost:8080/login/editUser',s);
  }


  

  public addUser(): Observable<boolean> {
    const url = 'http://localhost:8080/login/addUser';
    
    const addUserStruct={
      firstName:this.users.firstName,
    lastName:this.users.lastName,
    email:this.users.email,
    password:this.users.password,
    role:this.users.role
    }
  
    return this.http.post<boolean>(url, this.users);
  }

  
  

  // addUserDetails(firstName: string, lastName: string, email: string, password: string) {
  //   const userDetails = {
  //     firstName: firstName,
  //     lastName: lastName,
  //     email: email,
  //     password: password
  //   };

  //   this.userData.push(userDetails);
  // }
  ngOnInit(){
    
  }

}
