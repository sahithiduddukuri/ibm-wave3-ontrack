import { Injectable, Input } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { throwError, from } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Ontrack } from '../ontrack';

@Injectable({
 providedIn: 'root'
})
export class SearchService {
private microServiceUrl: string;
 private errorStatus: string;
 private errorBody: string;

  constructor(private http: HttpClient) {
      this.microServiceUrl = 'http://localhost:8999/api/v1/';
  }

  searchByProductStartsWith(productBrand: string) {
   const regx = `${productBrand}`;
   console.log('Regx', regx);
   console.log('hello world' + this.microServiceUrl + 'search-brand/' + productBrand);
   console.log( 'result' + this.http.get(this.microServiceUrl + 'search-brand/' + productBrand , { observe: 'response' }));
   return this.http.get(this.microServiceUrl + 'search-brand/' + productBrand , { observe: 'response' })
   .pipe(catchError(this.handleError));
 }

 private handleError(error: HttpErrorResponse) {
   if (error.error instanceof ErrorEvent) {
     console.log('An error occured :', error.error.message);
   } else {
     this.errorStatus = `${error.status}`;
     console.log('Error msg', this.errorStatus);
     this.errorBody = `${error.error}`;
     console.log(
       `Backened returned code ${error.status},` + `body was :${error.error}`
     );
   }

   return throwError(this.errorStatus);
 }
}
