import { Injectable, Input } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Myregistration } from '../classes/myregistration';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  url: string;
   response: any;
   get: any;
   httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
constructor(private http: HttpClient ) {}
addregister(reg: Myregistration) {
  console.log(reg);
  this.url = 'http://localhost:8805/api/v1/registration';
 return this.http.post(this.url, JSON.stringify(reg) , this.httpOptions);
 }
 profile(userId: String) {
  this.url = 'http://localhost:8015/api/v1/user/' + userId;
  return this.http.get(this.url);
 }
}
