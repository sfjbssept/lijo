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
  constructor(public flightService : FlightService ) { }

  ngOnInit(): void {
    this.flightService.searchFlight().subscribe({
      error: (e) => { console.log("error"+e)},    // errorHandler 
      next: (d) => { 
        this.flightSchedules =d as FlightSchedule[];

      },     // nextHandler
    });

}
}
