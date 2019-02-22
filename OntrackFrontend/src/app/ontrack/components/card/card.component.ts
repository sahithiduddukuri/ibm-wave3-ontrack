import { Router } from '@angular/router';
import { Ontrack } from './../../ontrack';
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
  AddToCart() {
    console.log('click event call');
    this.cartAddEvent.emit(this.cart);
   this.route.navigateByUrl('/AddToCart');
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
//  addToCart() {
//    this.route.navigate(['/', 'AddToCart']);
//  }
 search() {
   if (this.productName !== '') {
    this.products = this.products.filter(res => {
      return res.productName.toLocaleLowerCase().match(this.productName.toLocaleLowerCase());
    });
   } else if (this.productName === '') {
     this.ngOnInit();
   }
 }
  }
