import { Component, OnInit, Input } from '@angular/core';
import { User } from 'firebase';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { OnTrackService } from '../../ontrack.service';
import { Myregistration } from '../../classes/myregistration';
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
  @Input()
  reg: Myregistration;
  constructor(private formBuilder: FormBuilder, private router: Router, private ontrack: OnTrackService) { }

  ngOnInit() {
    this.ontrack.profile().subscribe(data => {
      console.log(data);
    });
  }
}
