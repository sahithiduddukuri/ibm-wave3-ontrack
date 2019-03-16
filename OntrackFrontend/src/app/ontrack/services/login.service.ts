import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private loginUrl = 'https://shoefly-zuul.stackroute.io/user-authentication/api/user';  // URL to web api

  constructor(
      private http: HttpClient, private router: Router ) {
  }

  login(user: any): Observable<any> {
      return this.http.post<any>(this.loginUrl, user);
  }
  logout() {
      console.log('i have entered in the logout function');
      localStorage.removeItem('token');
      this.router.navigate([`/cards`]);  // after logging out ,it should redirect to homepage
    }

  setCookie(cname: string, cvalue: string, exdays: number) {
      const date = new Date();
      date.setTime(date.getTime() + (exdays * 24 * 60 * 60 * 1000));
      const expires = `expires=${date.toUTCString()}`;
      document.cookie = `${cname}=${cvalue};${expires};path=/`;
  }

  getCookie(cname: string) {
      const name = cname + '=';
      const ca = document.cookie.split(';');
      for (let i = 0; i < ca.length; i++) {
          let c = ca[i];
          while (c.charAt(0) === ' ') {
              c = c.substring(1);
          }
          if (c.indexOf(name) === 0) {
              return c.substring(name.length, c.length);
          }
      }
      return '';
  }

  deleteCookie(cname: string) {
      document.cookie = `${cname}=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;`;
  }
}
