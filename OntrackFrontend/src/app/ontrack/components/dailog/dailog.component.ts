import { OnTrackService } from './../../ontrack.service';
import { Ontrack } from './../../ontrack';
import { Router } from '@angular/router';
import { Component, OnInit, Inject, Input, Output, EventEmitter} from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
@Component({
  selector: 'app-dailog',
  templateUrl: './dailog.component.html',
  styleUrls: ['./dailog.component.scss']
})
export class DailogComponent implements OnInit {
  productDTO: any = [];
  constructor(
    public dialogRef: MatDialogRef<DailogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any, private onTrack: OnTrackService, public route: Router
    ) {}
    // productName: String;
    //   @Input()
    //   o: any;
      // cart: any ;
      // @Output()
      //  cartAddEvent = new EventEmitter<any>();
      // dialogResult: any;
      // AddToCart(o): void {
      //   console.log(o, 'click event call');
      //   this.cartAddEvent.emit(o);
      //   this.onTrack.cart = o;
      //  this.route.navigateByUrl('/AddToCart');
      // }
    ngOnInit() {
      this.onTrack.openDailog().subscribe(data => {
        this.productDTO = data;
      });
    }
  closeDailog() {
    this.dialogRef.close('');
  }
  buy1() {
    this.route.navigate(['/' , 'buy1']);
  }
  AddtoCart() {
    this.route.navigate(['/' , 'AddtoCart']);
  }
}

