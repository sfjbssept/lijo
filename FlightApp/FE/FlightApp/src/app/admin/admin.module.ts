import { NgModule } from '@angular/core';
import { CommonModule, registerLocaleData } from '@angular/common';
import { RegisterFlightComponent } from './register-flight/register-flight.component';
import { Router, RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { FormsModule } from '@angular/forms';
import { FlightComponent } from './flight/flight.component';
import { FlightScheduleComponent } from './admin/flight-schedule/flight-schedule.component';
import { FontAwesomeModule ,FaIconLibrary,} from '@fortawesome/angular-fontawesome';
import { faCoffee, faFilm, faPenToSquare, faTrash } from '@fortawesome/free-solid-svg-icons';
import { faStackOverflow } from '@fortawesome/free-brands-svg-icons';


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
    FontAwesomeModule
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
