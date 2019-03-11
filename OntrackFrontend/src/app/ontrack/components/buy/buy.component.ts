import { Ontrack } from './../../classes/ontrack';
import { Route } from '@angular/compiler/src/core';
import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';
import { OnTrackService } from '../../services/ontrack.service';
@Component({
  selector: 'app-buy',
  templateUrl: './buy.component.html',
  styleUrls: ['./buy.component.scss']
})
export class BuyComponent implements OnInit {
  price: string;
  slotsAvailable: any = [];

  receiveMessage(data) {
    this.price = data;
  }
  constructor(private route: Router, private onTrack: OnTrackService) {  }
   ngOnInit() {
    this.onTrack.Buy().subscribe(data => {
      console.log('data fetch from response', data);
      this.slotsAvailable = data;
    });
  }
shop() {
this.route.navigate(['/' , 'payment']);
}
}
