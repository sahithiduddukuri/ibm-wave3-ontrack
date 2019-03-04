import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';
@Component({
  selector: 'app-buy',
  templateUrl: './buy.component.html',
  styleUrls: ['./buy.component.scss']
})
export class BuyComponent implements OnInit {
  // myControl = new FormControl();
  // options: string[] = ['Today', 'Tommorow', 'Day After Tommorow'];
  // filteredOptions: Observable<string[]>;
  items: Array<any> = [];
  constructor(private route: Router) { this.items = [
    {name : ' 28/02/2018 '},
    {name : ' 1/03/2019 '},
    {name : ' 2/03/2019 '}  ];
}
Ctrl($scope) {
    $scope.date = new Date();
}
  ngOnInit() {
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
