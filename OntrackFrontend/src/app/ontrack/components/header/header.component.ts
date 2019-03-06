import { LoginService } from './../../services/login.service';
import { Component, OnInit, Input } from '@angular/core';
import { Route } from '@angular/compiler/src/core';
import { RouterEvent, Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})

export class HeaderComponent implements OnInit {
  flag: boolean;
 userLogged: boolean;
  products: any = [];
  constructor(private route: Router, private loginService: LoginService) { }
  @Input() name;
condition: boolean;
text: String;
  ngOnInit() {
    console.log(this.name);
    if (localStorage.getItem('token') !== null ) {
      this.flag = true;
     this.userLogged = false;
    } else {
      this.flag = false;
     this.userLogged = true;
       }
   }
  Login() {
    this.route.navigate(['/' , 'login']);
  }
  Signup() {
    this.route.navigate(['/' , 'Signup']);
  }
  cartbutton() {
    this.route.navigate(['/', 'cartbutton']);
  }
  profile() {
    this.route.navigate(['/', 'profile']);
  }
  searchbar() {
    this.route.navigate(['/', 'search', this.text]);
  }
  logout() {
    this.loginService.logout();
     this.flag = false;
     this.userLogged = true;
   // location.reload();
  }
  search(value) {
    this.text = value;
  }
  // search() {
  //   if (this.products.Product_name !== '') {
  //    this.products = this.products.filter(res => {
  //      return res.this.products.Product_name.toLocaleLowerCase().match(this.products.Product_name.toLocaleLowerCase());
  //    });
  //   } else if (this.products.Product_name === '') {
  //     this.ngOnInit();
  //   }
  // }
}
