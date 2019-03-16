import { AngularFireDatabase } from '@angular/fire/database';
import { Router } from '@angular/router';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { DailogComponent } from './../dailog/dailog.component';
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { OnTrackService } from '../../services/ontrack.service';
import { SearchService } from '../../services/search.service';
import { Ontrack } from '../../classes/ontrack';
import { JwtHelperService } from '@auth0/angular-jwt';
import { map  } from 'rxjs/operators';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit {
  // tslint:disable-next-line:max-line-length
constructor(public dialog: MatDialog, private onTrack: OnTrackService, public route: Router, private searchService: SearchService, private db: AngularFireDatabase) { }
products: any = [];
productName: String;
productsInfo: Ontrack;
@Input() Ontrack: any;
private ontracks: Ontrack;
  @Input()
  product: any;
  cart: any ;
  key: any;
  @Output()
   cartAddEvent = new EventEmitter<any>();
   dialogResult: any;
   private helper = new JwtHelperService();
  private currentUser = this.currentUser = this.helper.decodeToken(localStorage.getItem('token'));
  AddToCart(product): void {
    console.log(product, 'click event call');
    this.cartAddEvent.emit(product);
    this.onTrack.cart = product;
   this.route.navigateByUrl('/AddToCart');
   let itemRef = this.db.list('/products');
   let items = itemRef.snapshotChanges().pipe(map(changes => changes.map(c => ({key: c.payload.key, ...c.payload.val()}))));
  //  items.subscribe(console.log)
   console.log('**************');
   items.subscribe(data => {
     console.log('data saved in firebased is******', data);
     this.key = data;
     this.ontracks = new Ontrack();
     console.log('key value while pushing$$$$$$$$$$$$', this.key.map(key =>{
       console.log('%%%%%%%%', key.key);
       this.ontracks.key = key.key;
       this.ontracks.brand = key.brand;
       this.ontracks.brandId = key.brandId;
       this.ontracks.colour = key.colour;
       this.ontracks.description = key.description;
       this.ontracks.dimension = key.dimension;
       this.ontracks.gender = key.gender;
       this.ontracks.imageURL = key.imageURL;
       this.ontracks.mrp = key.mrp;
       this.ontracks.price = key.price;
       this.ontracks.productName = key.productName;
       this.ontracks.productType = key.productType;
       this.ontracks.weight = key.weight;
      //    console.log('this is the value of track Service***&&&&&*******', this.ontracks);
     }));
   });
  //  this.db.list('/products').valueChanges().subscribe(data => {
  //   console.log('data value', data);
  // });
 
  product.userName = this.currentUser.jti;
   this.db.list('/products').push(product);
  //  this.db.list('/productsList').push(this.ontracks);
  }
  buys() {
    this.route.navigate([ '/', 'buys']);
  }
  openDialog(o): void {
    console.log(o, 'this is the data ');
   const dialogRef = this.dialog.open(DailogComponent,  {
     data: { o }
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.dialogResult = result;
    });
}
ngOnInit() {
        this.onTrack.Home().subscribe(data => {
          console.log(data);
          this.products = data;
        });
 }
}
