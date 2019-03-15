import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

@Injectable()
export class ChartsService {

  constructor(
    private http: HttpClient) {
  }

  getJSON(date, slot): Observable<any> {

    return this.http.get('http://ontrack.stackroute.io/delivery-manager/api/v1/routes' + "?" + "date=" + date + "&" + "slotType=" + slot);
  }
}





