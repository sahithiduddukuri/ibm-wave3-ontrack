import { Injectable, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
    providedIn: 'root'
})
export class SearchService {
    url: string;
    response: any;
    get: any;
    // @Input()
    // springEndPoint: String;
 constructor(private http: HttpClient ) {}
    //     this.springEndPoint = 'http://localhost:8082/api/v1/';
   searchfilter(searchText: string) {
   // this.url = 'http:localhost:8082/api/v1/product/name?shoes=sports wear';
    this.http.get('http://localhost:8082/api/v1/product/name?shoes=sports wear').subscribe(resp => {
        console.log(resp);
    this.response = resp;
        });
    return this.response;
    }
 }
