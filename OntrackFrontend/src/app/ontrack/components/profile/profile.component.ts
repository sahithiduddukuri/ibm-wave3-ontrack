import { Component, OnInit } from '@angular/core';
import { User } from 'firebase';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  user: User;
  first: any;
  editForm: FormGroup;
  userService: any;
  constructor(private formBuilder: FormBuilder, private router: Router) { }

  ngOnInit() {
  }
}
