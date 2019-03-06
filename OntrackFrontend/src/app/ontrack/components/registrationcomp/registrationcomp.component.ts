import { Component, OnInit, Input } from '@angular/core';
import { RegserviceService } from '../../services/regservice.service';
import { Myregistration } from '../../classes/myregistration';
import { RegistrationService } from '../../services/registration.service';
import { HttpClient } from '@angular/common/http';
import { registerContentQuery } from '@angular/core/src/render3';
import { FormControl, Validators, FormGroupDirective, NgForm, FormGroup, FormBuilder } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material';

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
  }

  export function MustMatch(controlName: string, matchingControlName: string) {
    return (formGroup: FormGroup) => {
        const control = formGroup.controls[controlName];
        const matchingControl = formGroup.controls[matchingControlName];

        if (matchingControl.errors && !matchingControl.errors.mustMatch) {
            // return if another validator has already found an error on the matchingControl
            return;
        }

        // set error on matchingControl if validation fails
        if (control.value !== matchingControl.value) {
            matchingControl.setErrors({ mustMatch: true });
        } else {
            matchingControl.setErrors(null);
        }
    };
}

@Component({
  selector: 'app-registrationcomp',
  templateUrl: './registrationcomp.component.html',
  styleUrls: ['./registrationcomp.component.scss']
})
export class RegistrationcompComponent implements OnInit {
  mobnumPattern = '^((\\+91-?)|0)?[0-9]{10}$';
  isValidFormSubmitted = null;
  registrationForm: FormGroup;
  submitted = false;
  matcher = new MyErrorStateMatcher();
  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);
  value: string;
  @Input()
  private regform: Myregistration;
  private name: string;
  private userId: string;
  private password: string;
  private mobileNo: string;
  private dateofBirth: string;
  private gender: string;
  formBuilder: any;
register(event: any) {
    this.regform = new Myregistration();
    this.regform.name = this.name;
    this.regform.userId = this.userId;
    this.regform.password = this.password;
    this.regform.mobileNo = this.mobileNo;
    this.regform.dateofBirth = this.dateofBirth;
    this.regform.gender = this.gender;
    console.log(this.regform);
    this.value = event.target.value;
    this.regserv.addregister(this.regform).subscribe(data => {
      console.log('data', data);
    });

  }
  constructor(private regserv: RegistrationService, private http: HttpClient) {
   console.log('name' , this.value);
  }
 ngOnInit() {
}
}
