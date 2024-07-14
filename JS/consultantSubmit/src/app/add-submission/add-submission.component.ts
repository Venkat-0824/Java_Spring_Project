import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SubmissionInfoService } from '../submission-info.service';

@Component({
  selector: 'app-add-submission',
  templateUrl: './add-submission.component.html',
  styleUrls: ['./add-submission.component.css']
})
export class AddSubmissionComponent implements OnInit {
  submissionForm!: FormGroup;

  constructor(private formBuilder: FormBuilder,private subSer:SubmissionInfoService) { }

  ngOnInit() {
    this.submissionForm = this.formBuilder.group({
      date: ['', Validators.required],
      consultantName: ['', Validators.required],
      technology: ['', Validators.required],
      leads: ['', Validators.required],
      salesPerson: ['', Validators.required],
      vendorName: ['', Validators.required],
      rate: ['', Validators.required]
    });
  }

  submissionData:any;
  // Add a method to handle form submission
  onSubmit() {
    // Retrieve the form values
     this.subSer.adddData = this.submissionForm.value;
    
    // TODO: Submit the form data to your API or perform desired actions
    console.log(this.subSer.adddData);

    this.subSer.addSubmission().subscribe(
      response => {
       if(response) 
       // Log the response to the console
      alert('added Sumission')
      this.submissionForm = this.formBuilder.group({
        date: ['', Validators.required],
        consultantName: ['', Validators.required],
        technology: ['', Validators.required],
        leads: ['', Validators.required],
        salesPerson: ['', Validators.required],
        vendorName: ['', Validators.required],
        rate: ['', Validators.required]
      });
      
      },
      error => {
        console.error(error); // Log any errors to the console
      }
    );
  }
}
