import { Component, OnInit } from '@angular/core';
import { FlightService } from '../flight.service';
import { FlightSchedule } from '../flightSchedule';

@Component({
  selector: 'app-flight-search',
  templateUrl: './flight-search.component.html',
  styleUrls: ['./flight-search.component.css']
})
export class FlightSearchComponent implements OnInit {

  flightSchedules!: FlightSchedule[];
  source: any ='GOA';
  destination: any = 'LONDON' ;
  constructor(public flightService : FlightService ) { }

  ngOnInit(): void {
   
}
calculateDuration(flightSchedule:FlightSchedule){
     // let hours = (new Date(flightSchedule.departureTime).getTime()- new Date(flightSchedule.arrivalTime).getTime());
      return new Date(flightSchedule.departureTime).getTime()- new Date(flightSchedule.arrivalTime).getTime();
  }
  searchFlights(){
    this.flightService.searchFlight(this.source,this.destination).subscribe({
      error: (e) => { console.log("error"+e)},    // errorHandler 
      next: (d) => { 
        this.flightSchedules =d as FlightSchedule[];

      },     // nextHandler
    });

  }
}

