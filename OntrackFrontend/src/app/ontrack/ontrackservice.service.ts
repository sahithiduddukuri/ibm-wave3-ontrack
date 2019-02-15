import { Injectable } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class OntrackserviceService {

  constructor() { }
<<<<<<< HEAD

  form: FormGroup = new FormGroup(
    {
      $key: new FormControl(null),
      name: new FormControl(''),
      userId: new FormControl(''),
      password: new FormControl(''),
      emailId: new FormControl(''),
      gender: new FormControl('1')
    });
=======
>>>>>>> 6feda0e1ab8986eae2136541a3c66d4fe2b966cd
}
