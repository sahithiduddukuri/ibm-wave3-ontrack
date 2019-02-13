import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-regcomp',
  templateUrl: './regcomp.component.html',
  styleUrls: ['./regcomp.component.scss']
})
export class RegcompComponent implements OnInit {

  constructor() { }

  // name: string;
  // userId: string;
  // password: string;
  // emailId: string;

  ngOnInit() {
  }

  // reg(): void {
  //   if (this.name === 'admin' && this.userId === 'admin' && this.emailId === 'admin' && this.password === 'admin'){
  //     this.router.navigate(['user']);
  //   } else {
  //     alert('Invalid credentials');
  //   }
  // }

}
