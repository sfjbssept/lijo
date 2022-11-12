import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
  rootURL = 'http://localhost:8090/flight-booking-service/';
  constructor(private httpCLient: HttpClient) { }
  bookTicket(value: any){
    return this.httpCLient.post(this.rootURL+'/booking', value,{responseType:'json'});
  }
}
