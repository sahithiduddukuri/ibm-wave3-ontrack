import { Component, OnInit } from '@angular/core';
import { OnTrackService } from '../ontrack.service';

@Component({
  selector: 'app-cartcomponent',
  templateUrl: './cartcomponent.component.html',
  styleUrls: ['./cartcomponent.component.scss']
})
export class CartcomponentComponent implements OnInit {
  cart: any;
  ontrackService: any;
  route: any;

  constructor(private service: OnTrackService) { }

  ngOnInit() {
      }
  addToCart() {
    this.ontrackService.getAddToCart().subscribe((res: any) => {
      this.cart = res.body;
      console.log(this.cart);
      });
  }

  CartToAdd(cart) {
    console.log(cart);
    this.service.AddToCart(cart);

  }
}


