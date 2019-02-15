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
   searchproduct(searchText: string) {
    this.http.get('http://localhost:8082/api/v1/product/name?shoes=formal wear').subscribe(resp => {
        console.log(resp);
    this.response = resp;
        });
    return this.response;
    }
 }
