
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';


@Injectable()
export class OnTrackService {
    url: any;
    response: any;
     cart;
    constructor(private http: HttpClient) {

    }
   Home() {
        this.url = 'http://0.0.0.0:3000/products';
        return this.http.get(this.url);
}
openDailog() {
    this.url = 'http://0.0.0.0:3000/products';
    return this.http.get(this.url);
}
AddToCart() {
    this.url = 'http://0.0.0.0:3000/products';
    return this.http.get(this.url);
}
}
