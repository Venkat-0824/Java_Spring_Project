import { Component, OnInit } from '@angular/core';
import { SubmissionInfoService } from '../submission-info.service';
import { Submission } from '../Submission';
import { distinct } from 'rxjs';

@Component({
  selector: 'app-maincontent',
  templateUrl: './maincontent.component.html',
  styleUrls: ['./maincontent.component.css']
})
export class MaincontentComponent implements OnInit {
[x: string]: any;
currentSubmission: any; 

submissionInfo:Submission[]=[];

leads: string[]=[];
technologies:string[]=[];

  onEdit(submission: any) {
    this.currentSubmission = submission;
  }


  constructor(public submissionDetails:SubmissionInfoService) { 
    
  }
  selectedSubmission!: Submission; 

  openModal(submission: Submission) {
    this.selectedSubmission = submission;
    
  }
  
 
selectedLead: string ='';

selectLead(lead: string) {
  this.selectedLead = lead;
  
}

  selectedTechnology: string = '';

  selectTechnology(technology: string) {
    this.selectedTechnology = technology;

  this.getSubmissions();
   
  }
 

  

  ngOnInit(): void {
    this.getSubmissions();
    this.leads=[...new Set(this.submissionDetails.info.map(a => a.leads))];
    
    
    this.technologies=[...new Set(this.submissionDetails.info.map(a => a.technology))];
    
  }

  onDelete(id: number) {
    this.submissionDetails.delSubmission(id)

    .subscribe(
      response => console.log(response),
      error => console.log(error)
    );
     
      this.submissionDetails.info = this.submissionDetails.info.filter(submission => submission.id !== id);
   
  }

  getSubmissions(): void {
    this.submissionDetails.getAll()
      .subscribe( response => {
        if(response) 
        
        this.submissionDetails.info=response;
        this.leads=[...new Set(this.submissionDetails.info.map(a => a.leads))];
        this.technologies=[...new Set(this.submissionDetails.info.map(a => a.technology))];
       
      });

     
        
        
      
  }
  




}
