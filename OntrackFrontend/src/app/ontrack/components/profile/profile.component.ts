import { Component, OnInit, Input } from '@angular/core';
import { User } from 'firebase';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { OnTrackService } from '../../services/ontrack.service';
import { Myregistration } from '../../classes/Myregistration';
import { Userlogin } from '../../classes/Userlogin';
import { RegistrationService } from '../../services/registration.service';
import * as jwt_decode from 'jwt-decode';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  register: any = [];
  @Input()
  reg: any;
  loginToken: Userlogin;
  jti: any;
  constructor(private services: RegistrationService, private router: Router) { }
  ngOnInit() {
    try {
      const tokenObtained = localStorage.getItem('token');
      this.loginToken = jwt_decode(tokenObtained);
      console.log('decoded token', jwt_decode(tokenObtained));
      this.jti = this.loginToken.jti;
      console.log('decoded token id', this.loginToken.jti);
      this.services.profile(this.jti).subscribe(data => {
        this.reg = data;
        console.log('this is reg response', this.reg);
     });
      } catch (error) {
        console.log(error);
      }
    }
  }
