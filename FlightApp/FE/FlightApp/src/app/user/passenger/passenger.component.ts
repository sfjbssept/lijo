import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl } from '@angular/forms';
import * as moment from 'moment';
import { Passenger } from '../passenger';
import { UserService } from '../user.service';

@Component({
  selector: 'app-passenger',
  templateUrl: './passenger.component.html',
  styleUrls: ['./passenger.component.css']
})
export class PassengerComponent implements OnInit {

  dobCtrl: FormControl = new FormControl("");
  isUpdate =false;
  minDate  = new Date(1900, 0, 1);
  maxDate= new Date();
  errorMessage ="";
  successMessage ="";
  passenger : Passenger;
  constructor(public userService: UserService) { }

  ngOnInit(): void {
    this.passenger = new Passenger();
  }
  onSubmit() {
    this.passenger.userId = 1;
    this.userService.savePassenger(this.passenger).subscribe({
     next:(data)=> {
      console.log(data);
     },
     error: ()=> {
      console.log("error");
     }
    })
   console.log(this.passenger);
  }
  openFromIcon(timepicker: { open: () => void }) {
    if (!this.dobCtrl.disabled) {
      timepicker.open();
    }
  }
  onClose() {
    let date1 = moment(this.passenger.dob); 
    let date2 = this.maxDate; 
    this.passenger.age = Math.abs(date1.diff(date2, 'years'));
  }
}
