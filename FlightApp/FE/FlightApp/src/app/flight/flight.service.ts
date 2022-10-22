import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  constructor(private http: HttpClient) { }
  rootURL = 'http://localhost:8090/flight-search-service/';
  
  public searchFlight(from: any,to: any) {
    const headers = new Headers();
    headers.append('Access-Control-Allow-Origin', '*');

    return this.http.get(this.rootURL+ "search" ,{ 
      params: new HttpParams().set('from',from).set('to',to),
      headers: new HttpHeaders().set('Access-Control-Allow-Origin', '*'), responseType: 'json'})
    }
}
