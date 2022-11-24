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

  arrivalTimeCtrl: FormControl = new FormControl("");
  departureTimeCtrl: FormControl = new FormControl("");
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
      localStorage.setItem('selectedFlight',null);
      this.flightSchedule = new FlightSchedule();
      this.internationalService = true;
      this.domesticService = true;
    }
  }
  resetMessages() {
    this.errorMessage = this.successMessage ="";
  }
  onSubmit(){
    console.log(this.flightSchedule);
    this.adminService.saveSchedule(this.flightSchedule).subscribe({
      next: (data:any) => {
        this.successMessage = data.message;
        this.form.reset();
      }
    });
    this.resetMessages();
  }
  getAllFlights(){
    this.adminService.getFligths().subscribe({
      next: data => {
      this.flights =data as Flight[];
      this.loadForm();
      },
      error: e => {
        this.errorMessage ="Some error Occured Please Try Again";
        console.log(e);
      }
    })
  }
  openFromIcon(timepicker: { open: () => void }) {
    if (!this.arrivalTimeCtrl.disabled) {
      timepicker.open();
    }
  }

  /**
   * Function to clear FormControl's value, called from the HTML template using the clear button
   *
   * @param $event - The Event's data object
   */
  onClear($event: Event) {
    this.arrivalTimeCtrl.setValue(null);
  }
  onClose(timepicker: { open: () => void } ,isArrival: Boolean) {
    if (isArrival && !this.arrivalTimeCtrl.disabled) {
      timepicker.open();
    } else if (!isArrival && !this.departureTimeCtrl.disabled) {
      timepicker.open();
    }
  }
  onCloseTimePicker(){
    let time = this.departureTimeCtrl.value;
    time = time.split(':');
    console.log("ddd"+this.departureTimeCtrl.value);
    const date = moment(this.flightSchedule.departureTime).set({hours: time[0], minutes: time[1]})
     this.flightSchedule.departureTime= date.toDate();
     this.setFlightDuration();
    console.log( this.flightSchedule.departureTime);
   
  }
  onCloseTimePicker2() {
    let time = this.arrivalTimeCtrl.value;
    time = time.split(':');
    console.log("ddd"+this.arrivalTimeCtrl.value);
    const date = moment(this.flightSchedule.arrivalTime).set({hours: time[0], minutes: time[1]})
     this.flightSchedule.arrivalTime= date.toDate();
    console.log( this.flightSchedule.arrivalTime);
    this.setFlightDuration();
  }
  setFlightDuration() {
    if(this.arrivalTimeCtrl.value && this.departureTimeCtrl.value) {
      let date1 = moment(this.flightSchedule.departureTime); 
      let date2 = moment(this.flightSchedule.arrivalTime); 
      let HOUR = Math.abs(date1.diff(date2, 'hours'));
      let minutes = Math.abs(date1.diff(date2, 'minutes'))%60;
    //  this.flightSchedule.flightDuration =new Date(this.flightSchedule.arrivalTime).getTime()- new Date(this.flightSchedule.departureTime).getTime();
      this.flightSchedule.flightDuration = HOUR+':h '+minutes+' :m';
    }
  }
}


