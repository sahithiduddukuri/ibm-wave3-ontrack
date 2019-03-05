import { CartComponent } from './../cart/cart.component';
import { Router } from '@angular/router';

import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { DailogComponent } from './../dailog/dailog.component';
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { OnTrackService } from '../../ontrack.service';
import { Search } from '../search/Search';
@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit {
  constructor(public dialog: MatDialog, private onTrack: OnTrackService, public route: Router) { }
  products: any = [];
productName: String;
  @Input()
  o: any;
  cart: any ;
  @Output()
   cartAddEvent = new EventEmitter<any>();
  dialogResult: any;
  AddToCart(o): void {
    console.log(o, 'click event call');
    this.cartAddEvent.emit(o);
    this.onTrack.cart = o;
   this.route.navigateByUrl('/AddToCart');

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
