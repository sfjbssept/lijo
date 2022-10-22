import { Component, OnInit } from '@angular/core';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-flight-search',
  templateUrl: './flight-search.component.html',
  styleUrls: ['./flight-search.component.css']
})
export class FlightSearchComponent implements OnInit {

  constructor(public flightService : FlightService ) { }

  ngOnInit(): void {
    this.flightService.searchFlight().subscribe({
      error: (e) => { console.log("error"+e)},    // errorHandler 
      next: (d) => { console.log(d)},     // nextHandler
    });

}
}
