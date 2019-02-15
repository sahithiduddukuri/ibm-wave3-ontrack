import { Injectable } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class OntrackserviceService {

  constructor() { }

  form: FormGroup = new FormGroup(
    {
      $key: new FormControl(null),
      name: new FormControl(''),
      userId: new FormControl(''),
      password: new FormControl(''),
      emailId: new FormControl(''),
      gender: new FormControl('1')
    });
}
