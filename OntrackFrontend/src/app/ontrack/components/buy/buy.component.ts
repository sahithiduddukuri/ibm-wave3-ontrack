import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-buy',
  templateUrl: './buy.component.html',
  styleUrls: ['./buy.component.scss']
})
export class BuyComponent implements OnInit {
  items: Array<any> = [];
  constructor(private route: Router) { this.items = [
    { name1 : '8-10' },
     { name2 : '1-4'},
    {name3 : '6-10'}
  ];
}

  ngOnInit() {
  }
shopping() {
this.route.navigate(['/' , 'shopping']);
}
}
