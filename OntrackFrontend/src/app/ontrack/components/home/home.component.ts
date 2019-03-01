import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})

export class HomeComponent implements OnInit {
  products: any;
  route: any;

  constructor() { }

  ngOnInit() {
  }

  Login() {
    this.route.navigate(['/' , 'login']);
  }
  Signup() {
    this.route.navigate(['/' , 'Signup']);
  }
 Profile() {
    this.route.navigate(['/' , 'profile']);
  }
  search() {
    if (this.products.Product_name !== '') {
     this.products = this.products.filter(res => {
       return res.this.products.Product_name.toLocaleLowerCase().match(this.products.Product_name.toLocaleLowerCase());
     });
    } else if (this.products.Product_name === '') {
      this.ngOnInit();
    }
  }

}
