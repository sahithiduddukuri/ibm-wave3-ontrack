// import { BuyComponent } from '../components/buy/buy.component';

import { HttpClient , HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';
import { Slot } from '../classes/Slot';
import { Order } from '../classes/Order';
import { SelectedSlot } from '../classes/SelectedSlot';


@Injectable()
export class OnTrackService {
    url: any;
    message: any = new Subject();
    response: any;
     cart;
     httpOptions = {
        headers: new HttpHeaders({ 'Content-Type': 'application/json' })
      };
    constructor(private http: HttpClient) {

    }
   Home() {

    this.url = 'https://shoefly-zuul.stackroute.io/product-service/api/v1/product';
    console.log('this method call');
    return this.http.get(this.url);
}

openDailog() {
    this.url = 'https://shoefly-zuul.stackroute.io/product-service/api/v1/product';
    return this.http.get(this.url);
}
AddToCart() {
    this.url = 'https://shoefly-zuul.stackroute.io/product-service/api/v1/product';
    return this.http.get(this.url);
}
openBottomSheet() {
return this.http.get(this.message);
}
Buy(order: Order) {

    this.url = ' https://ontrack-zuul.stackroute.io/delivery-manager/api/v1/slot';
    return this.http.post(this.url, JSON.stringify(order) , this.httpOptions);
 }
 OrderSave(slot: Slot) {
   this.url = 'https://ontrack-zuul.stackroute.io/delivery-manager/api/v1/saveorder';
    return this.http.post(this.url, JSON.stringify(slot), this.httpOptions);
 }
profile() {
    this.url = 'https://shoefly-zuul.stackroute.io/user-registration-service/api/v1/user/';
    return this.http.get(this.url);
}
REMOVE() {
    this.url = 'https://shoefly-zuul.stackroute.io/product-service/api/v1/product';
    return this.http.get(this.url);
 }

 saveSlot(selectedSlot: SelectedSlot) {
     this.url = 'https://ontrack-zuul.stackroute.io/delivery-manager/v1/slotbooked';
      return this.http.post(this.url, JSON.stringify(selectedSlot), this.httpOptions);
 }
}
