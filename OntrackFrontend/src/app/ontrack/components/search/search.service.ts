import { Injectable, Input } from '@angular/core';
import { HttpClient } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';
import 'rxjs/add/operator/switchMap';
@Injectable({
    providedIn: 'root'
})
export class SearchService {
    baseUrl: String = 'https://api.cdnjs.com/libraries';
  queryUrl: String = '?search=';
  debounceTime: any;

  constructor(private http: HttpClient) { }

  search(terms: Observable<string>) {
    return terms.debounceTime(400)
      .distinctUntilChanged()
      .switchMap(term => this.searchEntries(term));
  }

  searchEntries(term) {
    return this.http
        .get(`this.baseUrl` + this.queryUrl + term)
        .map(res => res.json());
  }
 }
