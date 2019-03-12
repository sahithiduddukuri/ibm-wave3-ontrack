import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContainerService {
  url: any;
  // private containerUrl = 'http://localhost:8011/api/v1/bookedslot';
  // return this.http.get(this.containerUrl);
 
   constructor(
       private http: HttpClient) {
   }

 containerMethod(){
   this.url = 'http://localhost:8018/api/v1/bookedslot';
   console.log('this method call');
   return this.http.get(this.url);
 }
}
