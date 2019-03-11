import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { AngularFireDatabase, AngularFireObject} from 'angularfire2/database';
import { Router } from '@angular/router';
​
@Component({
 selector: 'app-buying-history',
 templateUrl: './buying-history.component.html',
 styleUrls: ['./buying-history.component.scss']
})
export class BuyingHistoryComponent implements OnInit {
products: any;
@Output() MessageEvent = new EventEmitter<string>();
 totalPrice(total) {
 total = 0;
  for (let count = 0; count < this.products.length; count++) {
      total +=  Number(this.products[count].price);
      console.log(total);
  }
  return total;
  this.MessageEvent.emit(this.totalPrice(total));
}
 constructor(private db: AngularFireDatabase, private route: Router) {  }
​
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
 }
 continue3() {
    this.route.navigate(['/' , 'continue']);
  }
  buy3() {
    this.route.navigate(['/' , 'buy']);
  }
​}
