import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  rootURL = 'http://localhost:8090/flight-admin-service/';
  constructor(public httpClient: HttpClient) { }

  getAirLineNames(){
    return this.httpClient.get(this.rootURL+"/admin/airline/name");
  }
  saveFlight(value: any,id: any) {
    return this.httpClient.post(this.rootURL+"/admin/flight/"+id,value,{responseType:'json'});
  } 
  getFligths(){
    return this.httpClient.get(this.rootURL+"/admin/flight");
  }
}
