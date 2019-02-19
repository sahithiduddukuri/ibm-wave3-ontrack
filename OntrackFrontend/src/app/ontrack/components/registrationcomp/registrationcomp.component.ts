import { Component, OnInit, Input } from '@angular/core';
import { RegserviceService } from '../../regservice.service';
import { Myregistration } from '../../classes/myregistration';
import { RegistrationService } from '../../services/registration.service';
import { HttpClient } from '@angular/common/http';
import { registerContentQuery } from '@angular/core/src/render3';

@Component({
  selector: 'app-registrationcomp',
  templateUrl: './registrationcomp.component.html',
  styleUrls: ['./registrationcomp.component.scss']
})
export class RegistrationcompComponent implements OnInit {
  value: string;
  @Input()
  private regform: Myregistration;
  private name: string;
  private userId: string;
  private password: string;
  private mobileNo: string;
  private dateofBirth: string;
  private gender: string;
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
