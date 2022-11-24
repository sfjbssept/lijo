import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Flight } from '../flight/flight';
import { FlightSchedule } from '../flight/flightSchedule';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  rootURL = 'http://localhost:8090/flight-admin-service/';
  constructor(public httpClient: HttpClient) { }

  getAirLineNames() {
    return this.httpClient.get(this.rootURL+"/admin/airline/name");
  }
  saveFlight(value: Flight,id: any) {
    if(id!==null)
    value.id = id;
    return this.httpClient.post(this.rootURL+"/admin/flight",value,{responseType:'json'});
  } 
  getFligths() {
    return this.httpClient.get(this.rootURL+"/admin/flight");
  }
  saveSchedule(value: FlightSchedule) {
    return this.httpClient.post(this.rootURL+"/admin/flight/schedule/add",value,{responseType:'json'});
  }
}
