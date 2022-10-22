import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  constructor(private http: HttpClient) { }
  rootURL = 'http://localhost:8090/flight-search-service/';
  
  public searchFlight() {
    const headers = new Headers();
    headers.append('Access-Control-Allow-Origin', '*');

    return this.http.get(+ "search?from=3&to=3" ,{headers: new HttpHeaders().set('Access-Control-Allow-Origin', '*'), responseType: 'json'})
    }
}
