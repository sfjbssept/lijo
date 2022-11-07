import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Passenger } from './passenger';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  rootURL = 'http://localhost:8090/flight-user-service/';
  constructor(public httpClient: HttpClient) { }

  savePassenger(value: Passenger)
  {
    return this.httpClient.post(this.rootURL+'user/passenger',value,{responseType:'json'})
  }
}
