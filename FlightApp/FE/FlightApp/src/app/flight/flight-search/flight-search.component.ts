import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import * as moment from 'moment';
import { FlightService } from '../flight.service';
import { FlightSchedule } from '../flightSchedule';
import { formatDate } from "@angular/common";
import { ActivatedRoute, Route, Router } from '@angular/router';

@Component({
  selector: 'app-flight-search',
  templateUrl: './flight-search.component.html',
  styleUrls: ['./flight-search.component.css']
})
export class FlightSearchComponent implements OnInit {

  flightSchedules!: FlightSchedule[];
  source: any ='GOA';
  destination: any = 'LONDON' ;
  depDate: any = moment().format("MM/DD/yyyy");
  depDate1 = new FormControl((new Date()).toISOString());
  constructor(public flightService : FlightService ,private router: Router ) { }

  ngOnInit(): void {
   console.log(this.depDate);
}
calculateDuration(flightSchedule:FlightSchedule){
     // let hours = (new Date(flightSchedule.departureTime).getTime()- new Date(flightSchedule.arrivalTime).getTime());
      return new Date(flightSchedule.departureTime).getTime()- new Date(flightSchedule.arrivalTime).getTime();
  }
  searchFlights(){
    console.log(this.depDate);
    console.log(this.depDate1.value);
    this.flightService.searchFlight(this.source,this.destination, formatDate(this.depDate1.value, 'yyyy-MM-dd', 'en-US')).subscribe({
      error: (e) => { console.log("error"+e)},    // errorHandler 
      next: (d) => { 
        this.flightSchedules =d as FlightSchedule[];

      },     // nextHandler
    });

  }
  onBooking(flightSchedule: FlightSchedule){
    localStorage.setItem('flightschedule',JSON.stringify(flightSchedule));
    this.router.navigate(['/booking']);
  }
}

