import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { FlightSchedule } from '../flight/flightSchedule';
import { Passenger } from '../user/passenger';
import { UserService } from '../user/user.service';
import { BookingService } from './booking.service';

@Component({
  selector: 'app-ticket-booking',
  templateUrl: './ticket-booking.component.html',
  styleUrls: ['./ticket-booking.component.css']
})
export class TicketBookingComponent implements OnInit {
  errorMessage ="";
  successMessage ="";
  flightCost: number;
  pnrNumber: string;
  form: FormGroup;
  bookingResponse: any;
  passengers: Passenger[];
  flightSchedule: FlightSchedule;
  constructor(private fb: FormBuilder, 
              private bookingService: BookingService,
              private userService: UserService,
              private route: Router) { }

  ngOnInit(): void {
    this.resetMessages();
    this.passengers = this.getAllPassengers();
    this.flightSchedule = JSON.parse(localStorage.getItem('flightschedule'));// as FlightSchedule;
    this.form = this.fb.group({
      bookingDate: [(new Date()).toISOString()],
      flightScheduleId: [this.flightSchedule.id],
      ticketDetail: this.fb.array([])
    });
  }
  resetMessages() {
    this.errorMessage = this.successMessage ="";
  }
  onSubmit() {
    console.log(this.form.value);
    this.bookingService.bookTicket(this.form.value).subscribe({
      next:(data: any)=>{
        console.log(data);
        this.bookingResponse = data.data;
        this.pnrNumber =this.bookingResponse.pnrNumber;
        this.successMessage = data.data.message;
      },
      error:(e)=>{
        console.log(e);
      }
    })
  }
  get ticketDetails() {
    return this.form.get('ticketDetail') as FormArray;
  }
  addPassenger(){
    const ticketDetail = this.fb.group({
      passengerId:[''],
      mealType: ['', Validators.required],
      flightClass: ['', Validators.required],
      status:['Booked'],
      ticketCost:[0]
    });
    this.ticketDetails.push(ticketDetail);
  }
  deletePassenger(i:number) {
    this.ticketDetails.removeAt(i);
  }
  //TODO Duplicatecode
  getAllPassengers(){
    //TODO
    this.userService.getAllPassengers().subscribe({
      next: data => {
      this.passengers =data as Passenger[];
      },
      error: e => {
        console.log(e);
      }
    });
    return this.passengers;
  }
  onChange(item: any) {
    const businessclassCost = this.flightSchedule.businessClassCost;
    const economyClassCost = this.flightSchedule.economyClassCost; 
    switch(item.get('flightClass').value){
      case 'business':
        item.get('ticketCost').setValue(businessclassCost)
        break;
      case 'economy':
        item.get('ticketCost').setValue(economyClassCost)
        break;
    } 
   this.calculateFlightCost();
}
onViewTicket(){
  this.route.navigate(['/pnr/'+this.pnrNumber]);
}
calculateFlightCost(){
  this.flightCost = 0;
  this.ticketDetails.controls.forEach(element => {
   this.flightCost = this.flightCost + element.get('ticketCost').value; 
  });
}
}
