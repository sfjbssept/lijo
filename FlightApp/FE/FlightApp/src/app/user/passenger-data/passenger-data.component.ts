import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/admin/admin.service';
import { Flight } from 'src/app/flight/flight';
import { Passenger } from '../passenger';
import { UserService } from '../user.service';

@Component({
  selector: 'app-passenger-data',
  templateUrl: './passenger-data.component.html',
  styleUrls: ['./passenger-data.component.css']
})
export class PassengerDataComponent implements OnInit {

  constructor(public userService: UserService) { }
  passengers : Passenger[];
  ngOnInit(): void {
    this.getAllPassengers();
  }

  getAllPassengers(){
    this.userService.getAllPassengers(1).subscribe({
      next: data => {
      this.passengers =data as Passenger[];
      },
      error: e => {
        console.log(e);
      }
    })
  }
}
