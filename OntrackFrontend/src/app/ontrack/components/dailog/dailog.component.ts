import { Ontrack } from './../../classes/ontrack';
import { SearchService } from './../../services/search.service';
import { OnTrackService } from '../../services/ontrack.service';
import { Router } from '@angular/router';
import { Component, OnInit, Inject, Input, Output, EventEmitter} from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
@Component({
  selector: 'app-dailog',
  templateUrl: './dailog.component.html',
  styleUrls: ['./dailog.component.scss']
})
export class DailogComponent implements OnInit {
  products: any = [];
  Ontrack: any = [];
  constructor(
    public dialogRef: MatDialogRef<DailogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any, private onTrack: OnTrackService, private searchService: SearchService, public route: Router
    ) {}
    // productName: String;
      @Input()
      q: any;
      cart: any ;
      @Output()
       cartAddEvent = new EventEmitter<any>();
      dialogResult: any;
      AddToCart(q): void {
        console.log(q, 'click event call');
        this.cartAddEvent.emit(q);
        this.onTrack.cart = q;
       this.route.navigateByUrl('/AddToCart1');
      }
    ngOnInit() {
      this.onTrack.openDailog().subscribe(data => {
        this.products = data;
      });
      this.searchService.openDailog1().subscribe(res => {
        this.Ontrack = res;
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
  // buy2() {
  //   this.route.navigate(['/' , 'buy2']);
  // }
  // AddtoCart1() {
  //   this.route.navigate(['/' , 'AddtoCart1']);
  // }
}

