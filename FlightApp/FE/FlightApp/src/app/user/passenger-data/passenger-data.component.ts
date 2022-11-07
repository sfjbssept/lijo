import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/admin/admin.service';
import { Flight } from 'src/app/flight/flight';

@Component({
  selector: 'app-passenger-data',
  templateUrl: './passenger-data.component.html',
  styleUrls: ['./passenger-data.component.css']
})
export class PassengerDataComponent implements OnInit {

  constructor(public adminService: AdminService) { }
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

}
