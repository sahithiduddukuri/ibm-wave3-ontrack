import { Component, OnInit, Input } from '@angular/core';
import { Route } from '@angular/compiler/src/core';
import { RouterEvent, Router } from '@angular/router';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})

export class HeaderComponent implements OnInit {
  products: any = [];
  constructor(private route: Router) { }
  @Input() name;
// condition: boolean;

  ngOnInit() { console.log(this.name);
  }
  Login() {
    this.route.navigate(['/' , 'login']);
  }
  Signup() {
    this.route.navigate(['/' , 'Signup']);
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
