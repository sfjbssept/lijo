import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FlightSchedule } from '../flight/flightSchedule';

@Component({
  selector: 'app-ticket-booking',
  templateUrl: './ticket-booking.component.html',
  styleUrls: ['./ticket-booking.component.css']
})
export class TicketBookingComponent implements OnInit {
  form: FormGroup;
  flightSchedule: FlightSchedule;
  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
   this.flightSchedule = JSON.parse(localStorage.getItem('flightschedule'));// as FlightSchedule;
   this.form = this.fb.group({
    mealType:['',Validators.required],
    flightClass:['',Validators.required]
   });
  }
  onSubmit() {
    console.log(this.form.value);
  }
}
