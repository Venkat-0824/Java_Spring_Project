import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Submission } from '../Submission';
import { SubmissionInfoService } from '../submission-info.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnChanges {
  @Input()
  submissioninput!: Submission;
 
  editSubmissionForm: FormGroup = this.createFormGroup();

  constructor(private formBuilder: FormBuilder,private subSer: SubmissionInfoService) { }

  ngOnChanges(changes: SimpleChanges): void {
    if(changes['submissioninput'] && changes['submissioninput'].currentValue) {
      this.editSubmissionForm = this.createFormGroup(changes['submissioninput'].currentValue);
    }
  }

  createFormGroup(submission: Submission = {} as Submission): FormGroup {
    return this.formBuilder.group({
      date: [submission.date || '', Validators.required],
      consultantName: [submission.consultantName || '', Validators.required],
      technology: [submission.technology || '', Validators.required],
      leads: [submission.leads || '', Validators.required],
      salesPerson: [submission.salesPerson || '', Validators.required],
      vendorName: [submission.vendorName || '', Validators.required],
      rate: [submission.rate || '', Validators.required]
    });
  }

  onSubmit() {



    const passingValue:Submission={
      id:this.submissioninput.id,
      date: this.editSubmissionForm.value.date,
      consultantName: this.editSubmissionForm.value.consultantName,
      technology: this.editSubmissionForm.value.technology,
      leads: this.editSubmissionForm.value.leads,
      salesPerson: this.editSubmissionForm.value.salesPerson,
      vendorName: this.editSubmissionForm.value.vendorName,
      rate: this.editSubmissionForm.value.rate
    }
    
    this.subSer.editsubmission(passingValue).subscribe(
      response => {
       if(response) 
       // Log the response to the console
      alert('Edited Succesfully')
      
      },
      error => {
        console.error(error); // Log any errors to the console
      }
    );
  }
}
