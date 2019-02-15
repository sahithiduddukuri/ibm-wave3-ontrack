import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router/router';

@Component({
  selector: 'app-logincomp',
  templateUrl: './logincomp.component.html',
  styleUrls: ['./logincomp.component.scss']
})
export class LogincompComponent implements OnInit {
  userId: string;
  password: string;
  Router: any;
  constructor(private authenticationService: AuthenticationService, private router: Router) { }

  ngOnInit() {
  }
  // login() {
  //   this.authenticationService.login(this.userId, this.password)
  //     .subscribe(
  //       data => {
  //         this.router.navigate(['**']);
  //       },
  //       (error) => {
  //       });
  //     }
}
