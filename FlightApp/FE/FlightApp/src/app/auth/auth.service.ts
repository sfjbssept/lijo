import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  _tokenExpirationDate: any;
  rootURL = 'http://localhost:8090/flight-user-service/';
  private _token: any;
  tokenData: any;
  tokenDataSubject = new BehaviorSubject<any>(null);
  authSubject = new Subject<any>();

  constructor(public httpClient: HttpClient) {
  }
  login(value: any) {
    return this.httpClient.post(this.rootURL + "/auth/login", value, { responseType: 'json' });
  }
  isLoggedIn() {
    this._token = localStorage.getItem('token');
    this.tokenData = JSON.parse(localStorage.getItem('tokenData'));
    if (this.tokenData) {
      this._tokenExpirationDate = this.tokenData.tokenExpirationDate;
    }else{
      this.authSubject.next({'isLoggedIn':false,'role':''});
      return false;
    }
    if ( this._tokenExpirationDate && new Date() > new Date(this._tokenExpirationDate)) {
      localStorage.clear();
      this.authSubject.next({'isLoggedIn':false,'role':''});
      return false;
    }
    return true;
  }
  getRole() {
    this.tokenData = JSON.parse(localStorage.getItem('tokenData'));
    if (this.tokenData) {
     return this.tokenData.role;
    } else{
      return '';
    }
  }
}
