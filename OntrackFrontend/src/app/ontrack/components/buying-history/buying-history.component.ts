import { Component, OnInit} from '@angular/core';
import { AngularFireDatabase, AngularFireObject} from 'angularfire2/database';
import { Router } from '@angular/router';
import {JwtHelperService} from '@auth0/angular-jwt';


@Component({
 selector: 'app-buying-history',
 templateUrl: './buying-history.component.html',
 styleUrls: ['./buying-history.component.scss']
})
export class BuyingHistoryComponent implements OnInit {
products: any;
dataProducts: any;

 constructor(private db: AngularFireDatabase, private route: Router) {  }

 private helper = new JwtHelperService();
 private currentUser;

 ngOnInit() {
  console.log('this is buying history');
  this.db.list('/products').valueChanges().subscribe(data => {
   console.log('data value from firebase', data);
   const pr = data;
   console.log('value of pr is ', pr);
   this.products = data;
   console.log('value in products', this.products);
  });
  console.log('data store in products', this.products);

  this.currentUser = this.helper.decodeToken(localStorage.getItem('token'));
  console.log(this.helper.decodeToken(localStorage.getItem('token')));

 }
 totalPrice() {
  let total = 0;
  for (let count = 0; count < this.products.length; count++) {
      total +=  Number(this.products[count].price);
      console.log(total);
  }
  return total;
}
 continue3() {
    this.route.navigate(['/' , 'continue']);
  }
  buy3() {
    this.route.navigate(['/' , 'buy']);
  }
  remove3(products_id) {
    //  console.log('this is remove');
    // this.route.navigate(['/' , 'remove']);
    this.db.list('/products').valueChanges().subscribe(data => {
      console.log('data value from firebase', data);
      this.dataProducts = data;
      this.dataProducts.map(resp => {
         console.log('this is response ', resp);
      });
    });

  // this.db.database().ref('.products');
    console.log('this is the image url', products_id);
    console.log('/products/' + products_id);
    this.db.list('/products/' + products_id).remove();
    // this.db.list('/products/-L_vPzpG7liLwgC5KxGX').remove();

    console.log(this.db.list('/products', ref => ref.orderByChild('userName').equalTo(this.currentUser.jti)));
    console.log('removed');
  }
}

