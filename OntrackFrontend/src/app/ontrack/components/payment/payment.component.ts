import { OrderComponent } from './../order/order.component';
import { Address } from './../../classes/address';
import { Component, OnInit, Output } from '@angular/core';
// import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Http, Headers } from '@angular/http';
import { RegistrationService } from '../../services/registration.service';
import * as jwt_decode from 'jwt-decode';
import { Userlogin } from '../../classes/Userlogin';
import { Slot } from '../../classes/Slot';
import { OnTrackService } from '../../services/ontrack.service';
import { SelectedSlot } from '../../classes/SelectedSlot';
import { DatePipe} from '@angular/common';
import { Router } from '@angular/router';
import {MatBottomSheet, MatBottomSheetRef} from '@angular/material';
import { EventEmitter } from 'events';
@Component({
 selector: 'app-payment',
 templateUrl: './payment.component.html',
 styleUrls: ['./payment.component.scss']
})
export class PaymentComponent implements OnInit {
  [x: string]: any;
 slot: Slot;
 nameOnCard: string;
 cardNumber: string;
 expiryMonth: string;
 expiryYear: string;
 cvc: string;
 message: string;
 reg: any;
 loginToken: Userlogin;
 jti: any;
 Address: any;
 SlotSeleted: SelectedSlot;
 // tslint:disable-next-line:max-line-length
 constructor(private http: Http, private registraion: RegistrationService, private ontarck: OnTrackService, private datePipe: DatePipe, private route: Router, private bottomSheet: MatBottomSheet) {}
 @Output()
 orderAddEvent = new EventEmitter();



 openBottomSheet(message): void {
  this.bottomSheet.open(OrderComponent, {
    data : {
      message: 'Transaction Successful'
    }
  });
  this.message = 'Loading...';
  // tslint:disable-next-line:prefer-const
  let form = document.getElementsByTagName('form')[0];
  (<any>window).Stripe.card.createToken({
    number: this.cardNumber,
    exp_month: this.expiryMonth,
    exp_year: this.expiryYear,
    cvc: this.cvc
  },   (status: number, response: any)  => {
    if (status === 200) {
      // this.message = 'Transaction successful';
      // this.ontarck.message.next()
      this.ontarck.message.next('Transaction successful');
      // tslint:disable-next-line:prefer-const
      let token = response.id;
       this.chargeCard(token);

       try {
         const tokenObtained = localStorage.getItem('token');
         this.loginToken = jwt_decode(tokenObtained);
         console.log('decoded token', jwt_decode(tokenObtained));
         this.jti = this.loginToken.jti;
         console.log('decoded token id', this.loginToken.jti);
         this.registraion.profile(this.jti).subscribe(data => {
           this.Address =  data;
           this.reg = data;
           console.log('response data', this.Address);
           console.log('this is reg response', this.Address.address.city);
           localStorage.setItem('location', this.Address.address.city);
        });
         } catch (error) {
           console.log(error);
         }
         this.slot =  new Slot();
         this.slot.noOfOrders = Number(localStorage.getItem('count'));
         this.slot.demand = Number(localStorage.getItem('count')) * 20;
         this.slot.orderDate = localStorage.getItem('date');
         this.slot.slotType = localStorage.getItem('slot');
         this.slot.orderLoc = localStorage.getItem('location');
         console.log('this is the slot value', this.slot);
        this.ontarck.OrderSave(this.slot).subscribe(resp => {
         console.log('response fron post', resp);
        });
     } else {
       this.message = response.error.message;
       this.ontarck.message.next(response.error.message);
       console.log(response.error.message);
     }
   });
  this.SlotSeleted = new SelectedSlot();
  this.SlotSeleted.date = this.datePipe.transform(new Date(), 'yyyy-MM-dd');
  this.SlotSeleted.orderDate = localStorage.getItem('date');
  this.SlotSeleted.slotType  = localStorage.getItem('slot');
  this.SlotSeleted.productCount = Number(localStorage.getItem('count'));
   this.ontarck.saveSlot(this.SlotSeleted).subscribe(resp => {
     console.log('data save after slot selection', resp);
   });
 }
 chargeCard(token: string) {
   // tslint:disable-next-line:prefer-const
   let headers = new Headers({'token': token, 'amount': 100});
   this.http.post('http://13.233.3.91:8014/payment/charge', {}, {headers: headers})
     .subscribe(resp => {
       console.log(resp);
     });
 }
 ngOnInit() {
}
 openLink(event: MouseEvent): void {
  this.bottomSheetRef.dismiss();
}
}
