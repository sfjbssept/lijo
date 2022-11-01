import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl } from '@angular/forms';
import { MomentDateAdapter } from '@angular/material-moment-adapter';
import { DateAdapter, MatDateFormats, MAT_DATE_FORMATS, MAT_DATE_LOCALE, MAT_NATIVE_DATE_FORMATS } from '@angular/material/core';
import { ActivatedRoute } from '@angular/router';
import * as moment from 'moment';
import { Flight } from 'src/app/flight/flight';
import { FlightSchedule } from 'src/app/flight/flightSchedule';
import { AdminService } from '../../admin.service';
import { AirLine } from '../airLine';

export const MY_FORMATS = {
  parse: {
    dateInput: 'l, LTS'
  },
  display: {
    dateInput: 'YYYY-MM-DD HH:mm',
    monthYearLabel: 'MMM YYYY',
    dateA11yLabel: 'LL',
    monthYearA11yLabel: 'MMMM YYYY',
    enableMeridian: true
  },
};
@Component({
  selector: 'app-flight-schedule',
  templateUrl: './flight-schedule.component.html',
  styleUrls: ['./flight-schedule.component.css'],
  providers: [
    {
      provide: DateAdapter,
      useClass: MomentDateAdapter,
      deps: [MAT_DATE_LOCALE],
    },

    { provide: MAT_DATE_FORMATS, useValue: MY_FORMATS },
  ],
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
        this.errorMessage ="Some error Occured Please Try Again";
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
  onClose(timepicker: { open: () => void }) {
    if (!this.formControlItem.disabled) {
      timepicker.open();
    }
  }
  onCloseTimePicker(){
    let time = this.formControlItem.value;
    time = time.split(':');
    console.log("ddd"+this.formControlItem.value);
    const date = moment(this.flightSchedule.departureTime).set({hours: time[0], minutes: time[1]})
     this.flightSchedule.departureTime= date.toDate();
    console.log( this.flightSchedule.departureTime);
   
  }

}
