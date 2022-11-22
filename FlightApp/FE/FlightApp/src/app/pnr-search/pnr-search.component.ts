import { CommonModule } from '@angular/common';
import { isNgTemplate, ThisReceiver } from '@angular/compiler';
import { Component, Input, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { SharedModule } from '../shared/shared.module';
import { BookingService } from '../ticket-booking/booking.service';
import { Passenger } from '../user/passenger';

@Component({
  standalone: true,
  selector: 'app-pnr-search',
  templateUrl: './pnr-search.component.html',
  imports:[SharedModule,CommonModule,FormsModule],
  styleUrls: ['./pnr-search.component.css']
})
export class PnrSearchComponent implements OnInit {
  @Input() pnrInput: string;
  pnr: string;
  pnrData: any;
  passengerList: Passenger[];
  errorMessage ="";
  successMessage ="";
  pnrUrl: string;
  constructor(private bookingService: BookingService,
    private acivatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.pnrUrl =  this.acivatedRoute.snapshot.paramMap.get('pnr');
    if(this.pnrUrl) {
    this.pnr =this.pnrUrl;
    this.getTicketDetailsByPnr(this.pnr);
    }else if (this.pnrInput) {
      this.pnr = this.pnrInput;
      this.getTicketDetailsByPnr(this.pnrInput);
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
