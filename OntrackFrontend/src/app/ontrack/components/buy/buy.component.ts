import { BuyingHistoryComponent } from './../buying-history/buying-history.component';
import { Ontrack } from './../../classes/ontrack';
import { Route } from '@angular/compiler/src/core';
import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';
import { OnTrackService } from '../../services/ontrack.service';
import { Button } from 'protractor';

@Component({
 selector: 'app-buy',
 templateUrl: './buy.component.html',
 styleUrls: ['./buy.component.scss']
})
export class BuyComponent implements OnInit {
 price: number;
 charge: any;
 p: any;
 r: any;
 slotsAvailable: any = [];
totalPrice() {
 console.log('this is child');
}
 constructor(private route: Router, private onTrack: OnTrackService) {  }
  ngOnInit() {
   this.onTrack.Buy().subscribe(data => {
     console.log('data fetch from response', data);
     this.slotsAvailable = data;
     this.price = Number(sessionStorage.getItem('price'));
  });
 }
 slot(value) {
    this.charge = value.cost;
   console.log(value.cost);
       sessionStorage.setItem('charge', value.cost);
 }
shop() {
this.route.navigate(['/' , 'payment']);
}
}
