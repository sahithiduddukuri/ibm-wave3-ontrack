import { AngularFireDatabase } from '@angular/fire/database';
import { CartComponent } from './../cart/cart.component';
import { Router } from '@angular/router';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { DailogComponent } from './../dailog/dailog.component';
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { OnTrackService } from '../../services/ontrack.service';
import { Search } from '../search/Search';
import { SearchService } from '../../services/search.service';
import { Ontrack } from '../../classes/ontrack';
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
@Input() Ontrack: any;
private ontracks: Ontrack[];
  @Input()
  product: any;
  cart: any ;
  @Output()
   cartAddEvent = new EventEmitter<any>();
   dialogResult: any;
   AddToCart(product): void {
    console.log(product, 'click event call');
    this.cartAddEvent.emit(product);
    this.onTrack.cart = product;
   this.route.navigateByUrl('/AddToCart');
   this.db.list('/products').valueChanges().subscribe(data => {
    console.log('data value', data);
  });
  this.db.list('/products').push(product);
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
