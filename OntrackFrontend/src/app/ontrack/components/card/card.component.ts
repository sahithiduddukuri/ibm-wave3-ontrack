
import { DailogComponent } from './../dailog/dailog.component';

import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { OnTrackService } from '../../ontrack.service';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})

export class CardComponent implements OnInit {
  constructor(public dialog: MatDialog) { }
  @Input()
  // tslint:disable-next-line:whitespace
  cart: any ;
  @Output()
   cartAddEvent = new EventEmitter<any>();

  // AddToCart() {
  //   console.log('1');
  //   this.cartAddEvent.emit(this.cart);
  // }

  dialogResult: any;
  ngOnInit() {
  }
  AddToCart() {
    console.log('click event call');
    this.cartAddEvent.emit(this.cart);
  }

  openDialog(): void {
   const dialogRef = this.dialog.open(DailogComponent, {
    // width: '600px',
    // height: '250px'
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.dialogResult = result;
    });
  }
}
