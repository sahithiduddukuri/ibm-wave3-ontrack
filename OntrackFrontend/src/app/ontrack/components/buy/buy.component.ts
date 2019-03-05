import { Ontrack } from './../../classes/ontrack';
import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
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
  // myControl = new FormControl();
  // options: string[] = ['Today', 'Tommorow', 'Day After Tommorow'];
  // filteredOptions: Observable<string[]>;
  // items: Array<any> = [];
  constructor(private route: Router, private onTrack: OnTrackService) {
    // this.items = [
    // {name : ' 28/02/2018 '},
    // {name : ' 1/03/2019 '},
    // {name : ' 2/03/2019 '}  ];
}

slotsAvailable: any = [];
// slots: any = [];


  ngOnInit() {
    this.onTrack.Buy().subscribe(data => {
      console.log('data fetch from response', data);
      this.slotsAvailable = data;
      // console.log('data from slot availability', this.slotsAvailable);
      // console.log(this.slotsAvailable.slots);
    });
    // this.filteredOptions = this.myControl.valueChanges
  //   .pipe(
  //     startWith(''),
  //     map(value => this._filter(value))
  //   );
  }
  // private _filter(value: string): string[] {
  //   const filterValue = value.toLowerCase();

  //   return this.options.filter(option => option.toLowerCase().includes(filterValue));
  // }
shopping() {
this.route.navigate(['/' , 'shopping']);
}
}
