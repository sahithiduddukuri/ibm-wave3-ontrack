
<<<<<<< HEAD
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';

@Injectable()
export class OnTrackService {
    url: any;
    response: any;
    constructor(private http: HttpClient) {

=======
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject, throwError } from 'rxjs';
import { Regclass } from './regclass';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class OnTrackService {
    url: any;
    response: any;
    usersubject: BehaviorSubject<any>;
    springEndPoint: string;
    errorStatus: string;
    errorBody: string;
    private regServiceUrl = 'http://localhost:8805/api/v1/';
    constructor(private http: HttpClient) {
        // this.usersubject = new BehaviorSubject([]);
        // this.springEndPoint = 'http://localhost:8805/api/v1/';
>>>>>>> 6feda0e1ab8986eae2136541a3c66d4fe2b966cd
    }
    AddToCart(cart: any) {
        console.log('clcik event call');
        console.log(cart);
        this.url = 'http://localhost:3000/products';
        this.http.get(this.url).subscribe(resp => {
            console.log(resp);
        this.response = resp;
            });
        return this.response;
<<<<<<< HEAD
}
}
=======
      }
      public createUser(regclass: Object): Observable<Object> {
        return this.http.post(`${this.regServiceUrl}` + `/registration`, regclass);
      }

    // addUsertoRegister(regclass: Regclass) {
    //     return this.http
    //     .post(this.springEndPoint + 'userregistrationservice/registration', regclass, { observe: 'response'})
    //     .pipe(catchError(this.handleError));
    // }

    // getAddedValues() {
    //   console.log('Added values');
    //   return this.http.get(this.springEndPoint + 'userregistrationservice', { observe: 'response'})
    //   .pipe(catchError(this.handleError));
    // }

    // private handleError(error: HttpErrorResponse) {
    //     if (error.error instanceof ErrorEvent) {
    //       // this.errorMsg = error.error.message;
    //       console.log('An error occured :', error.error.message);
    //     } else {
    //       this.errorStatus = `${error.status}`;
    //       console.log('Error msg', this.errorStatus);
    //       this.errorBody = `${error.error}`;
    //       console.log(
    //         `Backened returned code ${error.status},` + `body was :${error.error}`
    //       );
    //     }
    //     return throwError(this.errorStatus);
    //   }
    }
>>>>>>> 6feda0e1ab8986eae2136541a3c66d4fe2b966cd
