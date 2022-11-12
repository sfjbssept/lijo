import { isNgTemplate } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BookingService } from '../ticket-booking/booking.service';
import { Passenger } from '../user/passenger';

@Component({
  selector: 'app-pnr-search',
  templateUrl: './pnr-search.component.html',
  styleUrls: ['./pnr-search.component.css']
})
export class PnrSearchComponent implements OnInit {
  pnr: string;
  pnrData: any;
  passengerList: Passenger[];
  errorMessage ="";
  successMessage ="";
  constructor(private bookingService: BookingService,
    private acivatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.pnr =  this.acivatedRoute.snapshot.paramMap.get('pnr');
    if(this.pnr) {
    this.getTicketDetailsByPnr(this.pnr);
    }
  }

  getTicketDetailsByPnr(value: string){
    this.resetMessage();
    this.bookingService.getTicketDetailsByPnrNumber(value).subscribe({
      next:(data:any)=>{
        console.log(data);
        this.pnrData = data.data;
        this.passengerList = this.pnrData.passengerDtoList;
      },
      error:(e)=>{
        this.errorMessage = e.error.message;
        console.log(e);
      }
    })
  }
  resetMessage() {
    this.successMessage =this.errorMessage ='';
  }
  getPassengerAge(id: number) {
   return this.passengerList.filter(item => item.id===id)[0].age;
  }
  getPassengerName(id: number) {
    return this.passengerList.filter(item => item.id===id)[0].name;
  }
  getPassengerGender(id: number) {
    return this.passengerList.filter(item => item.id===id)[0].gender;
  }
}
