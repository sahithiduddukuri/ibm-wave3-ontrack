import { OnTrackService } from './../../ontrack.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {
  service: any;
  products: Object;
  constructor(private route: Router, private onTrack: OnTrackService) { }

  ngOnInit() {
    this.onTrack.AddToCart().subscribe(data => {
      console.log(data);
      this.products = data;
    });
  }
  // CartToAdd(cart) {
  //   console.log(cart);
  //   this.service.AddToCart(cart);
  // }
}
