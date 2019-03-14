import { MatDialog } from '@angular/material';
import { Component, OnInit } from '@angular/core';
// import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Http, Headers } from '@angular/http';
import { Router } from '@angular/router';
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

  constructor(private http: Http, private router: Router) {}
  ngOnInit() {
  }
  chargeCreditCard() {
    this.message = 'Loading...';
    // tslint:disable-next-line:prefer-const
    let form = document.getElementsByTagName('form')[0];
    (<any>window).Stripe.card.createToken({
      number: this.cardNumber,
      exp_month: this.expiryMonth,
      exp_year: this.expiryYear,
      cvc: this.cvc
    }, (status: number, response: any) => {
      if (status === 200) {
        // tslint:disable-next-line:prefer-const
        let token = response.id;
        this.chargeCard(token);
        this.router.navigate([`/order`]);
      } else {
        this.message = response.error.message;
        console.log(response.error.message);
      }
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
}
