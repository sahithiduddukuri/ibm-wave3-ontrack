import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { importType } from '@angular/compiler/src/output/output_ast';
import { HomeService } from '../services/Home.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
 slotsAvailable: any = [];
 url: any;
totalPrice() {
 console.log('this is child');
}
 constructor(private home: HomeService) {  }
  ngOnInit() {
   this.home.Buy().subscribe(data => {
     console.log('data fetch from response', data);
     this.slotsAvailable = data;
  });

  }
 slot() {
    console.log('slots' + this.slotsAvailable);
 }

}

