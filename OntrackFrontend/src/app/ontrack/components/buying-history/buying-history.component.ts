// import { Component, OnInit } from '@angular/core';
// import { FirebaseListObservable } from 'angularfire2/database-deprecated';
// import { AngularFireDatabase, AngularFireObject} from 'angularfire2/database';
// ​
// @Component({
//  selector: 'app-buying-history',
//  templateUrl: './buying-history.component.html',
//  styleUrls: ['./buying-history.component.scss']
// })
// export class BuyingHistoryComponent implements OnInit {
// products: AngularFireObject <any>;
// ​
//  constructor(private db: AngularFireDatabase) { }
// ​
//  ngOnInit() {
//   console.log('this is buying history');
//   this.db.list('/products').valueChanges().subscribe(data => {
//    console.log('data value from firebase', data);
//    this.products = data;
//   });
//   console.log('data store in products', this.products);
//  }
// ​}
