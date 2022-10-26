import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Flight } from 'src/app/flight/flight';
import { AdminService } from '../admin.service';
import { AirLine } from '../admin/airLine';

@Component({
  selector: 'app-register-flight',
  templateUrl: './register-flight.component.html',
  styleUrls: ['./register-flight.component.css']
})
export class RegisterFlightComponent implements OnInit {
 
  flight: Flight;
  isUpdate =false;
  errorMessage ="";
  successMessage ="";
  status = "active";
  internationalService = "true";
  domesticService = "true";
  @ViewChild('form') form: any;
  airLineList: AirLine[];
  constructor(public adminService: AdminService, public route: ActivatedRoute) { 
    this.route.queryParams.subscribe(params=>{
    this.isUpdate =params['isUpdate'];
    })
  }

  ngOnInit(): void {
    console.log(this.flight);
    this.resetMessages(this.flight);
    this.adminService.getAirLineNames().subscribe({
     error: (e) => {console.log(e)} , // errorHandler 
     next: (d) => {
       this.airLineList = d as AirLine[];
       this.loadForm();
     }
    });
  }
  loadForm() {
    //this.flight.id = this.airLineList[0].id;
    if(this.isUpdate) {
      let jsonObject = JSON.parse(localStorage.getItem('selectedFlight'));
      this.flight = jsonObject as Flight;
      console.log(this.airLineList);
      console.log(this.flight.id);

    }else{
      localStorage.clear();
      this.flight = new Flight();
    }
  }
  resetMessages(flight: Flight) {
    this.errorMessage = this.successMessage ="";
    this.internationalService = flight? (flight.internationalService=='1'?"true":"false"): "true";
    this.domesticService =flight? (flight.internationalService=='1'?"true":"false"): "true";
  }
  onSubmit(){
    this.resetMessages(null);
    this.form.value.internationalService = this.form.value.internationalService?"1":"0";
    this.form.value.domesticService = this.form.value.domesticService?"1":"0";
    this.adminService.saveFlight(this.form.value,this.form.value.airlineId).subscribe({
      next: (data:any) => {
        this.successMessage = data.message;
        this.form.reset();
        console.log(data);
    },
    error: error => {
      if(error.status===409) {
        this.errorMessage = error.error.message;
        console.error('There was an error!', error);
      }
    }
    });
  }

}
