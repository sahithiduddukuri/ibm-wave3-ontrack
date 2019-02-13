import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { OnTrackService } from '../../ontrack.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit {
  @Input()
  // tslint:disable-next-line:whitespace
  cart: any ;
  @Output()
   cartAddEvent = new EventEmitter<any>();
  constructor() { }

  ngOnInit() {
  }
  AddToCart() {
    console.log('click event call');
    this.cartAddEvent.emit(this.cart);
  }

  // AddToCart() {
  //   console.log('1');
  //   this.cartAddEvent.emit(this.cart);
  // }

}
