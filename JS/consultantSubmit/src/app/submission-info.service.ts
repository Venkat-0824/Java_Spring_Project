import { Injectable } from '@angular/core';
import { Submission } from './Submission';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AddSubmissionComponent } from './add-submission/add-submission.component';

@Injectable({
  providedIn: 'root'
})
export class SubmissionInfoService {

  info: Submission[] = [];

  constructor(private http: HttpClient) { 
    
  }
  adddData={
    date: '',
    consultantName: '',
    technology: '',
    leads: '',
    salesPerson: '',
    vendorName: '',
    rate: 0
  }

  public getAll(): Observable<Submission[]> 
  {
    const url = 'http://localhost:8080/login/getAll';
 
    return this.http.get<Submission[]>(url);
  }

  public addSubmission():Observable<boolean>{
    const url = 'http://localhost:8080/login/addSubmission';
 
    return this.http.post<boolean>(url,this.adddData);

  }


  public delSubmission(id:number):Observable<any>{
    return  this.http.delete(`http://localhost:8080/login/delSubmission/${id}`);

  }

  public editsubmission(s:Submission):Observable<Submission>{
    return this.http.post<Submission>('http://localhost:8080/login/editSubmission',s);
  }








// Push a new Submission object to the array




}
