
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';


@Injectable()
export class OnTrackService {
    url: any;
    response: any;
    constructor(private http: HttpClient) {

    }
   Home() {
        this.url = 'http://localhost:3000/products';
        return this.http.get(this.url);
}
openDailog() {
    this.url = 'http://localhost:3000/products';
    return this.http.get(this.url);
}
AddToCart() {
    this.url = 'http://localhost:3000/products';
    return this.http.get(this.url);
}
}
