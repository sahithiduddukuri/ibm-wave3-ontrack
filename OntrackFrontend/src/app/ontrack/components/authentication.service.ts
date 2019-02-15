import { Injectable } from '@angular/core';
// import { HttpHeaders, BaseRequestOptions, Response, ResponseOptions } from '@angular/common/http';
// import { Http } from '@angular/http';
// import { JwtHelper } from 'angular2-jwt';
import 'rxjs/add/operator/map';
// import { tokenNotExpired } from 'angular2-jwt';
import { promise } from 'protractor';
import { catchError } from 'rxjs/operators';
// import { JwtToken } from './jwt-token';
//  import { Observable } from 'rxjs/Observable';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  public token: string;
  public message: string;
  public userId: string;
  public password: string;
  post: any;
  url: string;
 // constructor(
// private http: HttpClient
//     ) {
//     this.url = 'http://localhost:8090/api/user';
//     const currentUser = JSON.parse(localStorage.getItem('currentUser'));
//     this.token = currentUser && currentUser.token;
//   }

//   private headers = new Headers({ 'Content-Type': 'application/json' });
//   login(userId: string, password: string)  {
//     return this.http.post(this.url, JSON.stringify({ userId: userId, password: password  , headers: this.headers}))
//         .forEach((response: Response) => {
//             const token = response.json() && response.json().token;
//             if (token) {
//                 this.token = token;
//                 localStorage.setItem('currentUser', JSON.stringify({ token: token, message: this.message }));
//                 return true;
//             } else {
//                 return false;
//             }
//         });
// }

// isLoggedIn() {
//     return tokenNotExpired();
// }

//   get currentUser() {
//       const oldtoken = JSON.parse(localStorage.getItem('currentUser'));
//       return new JwtHelper().decodeToken(oldtoken.token);
//   }
}
