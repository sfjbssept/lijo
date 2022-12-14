import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
  rootURL = 'http://localhost:8090/flight-booking-service/booking';
  constructor(private httpCLient: HttpClient) { }
  bookTicket(value: any){
    return this.httpCLient.post(this.rootURL+'/user', value,{responseType:'json'});
  }
  getTicketDetailsByPnrNumber(pnrNumber:string) {
    return this.httpCLient.get(this.rootURL+'/pnr/'+pnrNumber);
  }
  getTicketDetailsByUserId() {
    const userId = localStorage.getItem('userId');
    return this.httpCLient.get(this.rootURL+'/user/history/'+userId);
  }
  cancelTicket(ticketId: Number) {
    return this.httpCLient.get(this.rootURL+'/user/'+ticketId);
  }
}
