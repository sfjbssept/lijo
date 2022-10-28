import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Flight } from 'src/app/flight/flight';
import { FlightSchedule } from 'src/app/flight/flightSchedule';
import { AdminService } from '../../admin.service';
import { AirLine } from '../airLine';

@Component({
  selector: 'app-flight-schedule',
  templateUrl: './flight-schedule.component.html',
  styleUrls: ['./flight-schedule.component.css']
})
export class FlightScheduleComponent implements OnInit {

  formControlItem: FormControl = new FormControl("");
  required: boolean = !1;
  @ViewChild("timepicker") timepicker: any;
  
  flightSchedule: FlightSchedule;
  depDate1:any;
  isUpdate =false;
  errorMessage ="";
  successMessage ="";
  status = "active";
  internationalService = true;
  domesticService = true;
  @ViewChild('form') form: any;
  airLineList: AirLine[];
  flights: Flight[];
  constructor(public adminService: AdminService, public route: ActivatedRoute) { 
    this.route.queryParams.subscribe(params=>{
    this.isUpdate =params['isUpdate'];
    })
  }

  ngOnInit(): void {
    this.getAllFlights();
    this.resetMessages();
    this.adminService.getAirLineNames().subscribe({
     error: (e) => {console.log(e)} , // errorHandler 
     next: (d) => {
       this.airLineList = d as AirLine[];
       this.loadForm();
     }
    });
  }
  loadForm() {
    if(this.isUpdate) {
    //   let jsonObject = JSON.parse(localStorage.getItem('selectedFlight'));
    //   this.flightSchedule = jsonObject as Flight;
    //   console.log(this.airLineList);
    //   console.log(this.flight.id);
    //   this.internationalService = this.flight.internationalService==='1'?true:false;
    // this.domesticService =this.flight.domesticService==='1'?true:false;
    }else{
      localStorage.clear();
      this.flightSchedule = new FlightSchedule();
      this.internationalService = true;
      this.domesticService = true;
    }
  }
  resetMessages() {
    this.errorMessage = this.successMessage ="";
  }
  onSubmit(){
    this.resetMessages();
    // this.form.value.internationalService = this.form.value.internationalService?"1":"0";
    // this.form.value.domesticService = this.form.value.domesticService?"1":"0";
    // this.adminService.saveFlight(this.form.value,this.isUpdate?this.flight.id:null).subscribe({
    //   next: (data:any) => {
    //     this.successMessage = data.message;
    //     this.form.reset();
    //     localStorage.clear();
    //     console.log(data);
    // },
    // error: error => {
    //   if(error.status===409) {
    //     this.errorMessage = error.error.message;
    //     console.error('There was an error!', error);
    //   }
    // }
    // });
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
  openFromIcon(timepicker: { open: () => void }) {
    if (!this.formControlItem.disabled) {
      timepicker.open();
    }
  }

  /**
   * Function to clear FormControl's value, called from the HTML template using the clear button
   *
   * @param $event - The Event's data object
   */
  onClear($event: Event) {
    this.formControlItem.setValue(null);
  }

}
