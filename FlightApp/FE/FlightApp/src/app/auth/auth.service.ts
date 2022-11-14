import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  _tokenExpirationDate: any;

  rootURL = 'http://localhost:8090/flight-user-service/';
  private _token: any;
  tokenData: any;
  constructor(public httpClient: HttpClient) {
    this._token = localStorage.getItem('token');
    this.tokenData = JSON.parse(localStorage.getItem('tokenData'));
    if (this.tokenData) {
      this._tokenExpirationDate = this.tokenData.tokenExpirationDate;
    }
  }
  login(value: any) {
    return this.httpClient.post(this.rootURL + "/auth/login", value, { responseType: 'json' });
  }
  isLoggedIn() {
    if ( this._tokenExpirationDate && new Date() > new Date(this._tokenExpirationDate)) {
      return false;
    }
    return true;
  }
}
