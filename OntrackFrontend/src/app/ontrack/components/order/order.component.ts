import { Component, OnInit, Input, Inject } from '@angular/core';
import { OnTrackService } from "../../services/ontrack.service";
import {MAT_BOTTOM_SHEET_DATA} from '@angular/material';


@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent implements OnInit {
  // @Input()
  // message1: String;
  message: any;
constructor(private os: OnTrackService, @Inject(MAT_BOTTOM_SHEET_DATA) public data: any) { }

  ngOnInit() {
    // console.log('this is in order');
    // sessionStorage.getItem('message');
    // console.log('this.message');
    this.message = this.data;
    this.os.message.subscribe(data => {
      this.message = data;
      console.log(typeof data, "is this comming here ??")
    });
  }
  openBottomSheet($event) {
    this.os.message.subscribe(data => {
      this.message = data;
      console.log(data, "is this comming here ??")
    });
  }
}
