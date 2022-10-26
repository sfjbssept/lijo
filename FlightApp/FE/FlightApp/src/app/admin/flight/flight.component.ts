import { Component, OnInit } from '@angular/core';
import { Route, RouteConfigLoadEnd, Router } from '@angular/router';
import { Flight } from 'src/app/flight/flight';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-flight',
  templateUrl: './flight.component.html',
  styleUrls: ['./flight.component.css']
})
export class FlightComponent implements OnInit {

  constructor(public adminService: AdminService, private route: Router) { }
  flights : Flight[];
  ngOnInit(): void {
    this.getAllFlights();
  }

  getAllFlights(){
    this.adminService.getFligths().subscribe({
      next: data => {
      this.flights =data as Flight[];
      },
      error: e => {
        console.log(e);
      }
    })
  }
  updateFlight(flight: Flight) {
   localStorage.setItem('selectedFlight',JSON.stringify(flight));
   this.route.navigate(['/admin/register/flight'],{queryParams:{'isUpdate':true}});
  }
}
