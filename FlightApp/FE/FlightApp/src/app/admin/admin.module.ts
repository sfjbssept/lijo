import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegisterFlightComponent } from './register-flight/register-flight.component';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FlightComponent } from './flight/flight.component';
import { FlightScheduleComponent } from './admin/flight-schedule/flight-schedule.component';
import { FontAwesomeModule ,FaIconLibrary,} from '@fortawesome/angular-fontawesome';
import { faCoffee, faFilm, faPenToSquare, faTrash } from '@fortawesome/free-solid-svg-icons';
import { faStackOverflow } from '@fortawesome/free-brands-svg-icons';
import { AngularMaterialModule } from '../AngularMaterialModule';
import { MatNativeDateModule } from '@angular/material/core';
import { NgxMatTimepickerModule } from 'ngx-mat-timepicker';
import { TicketBookingComponent } from '../ticket-booking/ticket-booking.component';

const routes: Routes = [
  {path:'', component: AdminComponent},
  {path:'flight',component: FlightComponent},
  {path:'register/flight' ,component: RegisterFlightComponent},
  {path:'flight/schedule' ,component: FlightScheduleComponent}
]
@NgModule({
  declarations: [
    RegisterFlightComponent,
    AdminComponent,
    FlightComponent,
    FlightScheduleComponent,
  ],
  imports: [
    FormsModule,
    CommonModule,
    RouterModule.forChild(routes),
    FontAwesomeModule,
    MatNativeDateModule,
    AngularMaterialModule,
    NgxMatTimepickerModule.setLocale('en-US'),
    ReactiveFormsModule
  ]
})
export class AdminModule { 
  constructor(library: FaIconLibrary) {
    library.addIcons(
      faCoffee,
      faStackOverflow,
      faFilm,
      faTrash,
      faPenToSquare
    );
  }
}
