import { Component, OnInit } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';


@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.scss']
})
export class PaymentComponent implements OnInit {
  nameOnCard: string;
  cardNumber: string;
  expiryMonth: string;
  expiryYear: string;
  cvc: string;
  message: string;

  constructor(private http: HttpClient) {}
  ngOnInit() {
  }

  // getToken() {
  //   this.message = 'Loading...';

  //   (<any>window).Stripe.card.createToken({
  //     number: this.cardNumber,
  //     exp_month: this.expiryMonth,
  //     exp_year: this.expiryYear,
  //     cvc: this.cvc
  //   }, (status: number, response: any) => {
  //     if (status === 200) {
  //       this.message = `Success! Card token ${response.card.id}.`;
  //     } else {
  //       this.message = response.error.message;
  //     }
  //   });
  // }
  chargeCreditCard() {
    const form = document.getElementsByTagName('form')[0];
    (<any>window).Stripe.card.createToken({
      number: form.cardNumber.value,
      exp_month: form.expMonth.value,
      exp_year: form.expYear.value,
      cvc: form.cvc.value
    }, (status: number, response: any) => {
      if (status === 200) {
        const token = response.id;
        this.chargeCard(token);
      } else {
        console.log(response.error.message);
      }
    });
  }
  chargeCard(token: string) {
  //   const headers = new Headers({'token': token, 'amount': 100});
  //   this.http.post('http://localhost:8014/payment/charge', {}, {headers: headers})
  //     .subscribe(resp => {
  //       console.log(resp);
  //     });
  // }
  }

}
