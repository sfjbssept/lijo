import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegisterFlightComponent } from './register-flight/register-flight.component';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FlightComponent } from './flight/flight.component';
import { FlightScheduleComponent } from './admin/flight-schedule/flight-schedule.component';
import { AngularMaterialModule } from '../AngularMaterialModule';
import { MatNativeDateModule } from '@angular/material/core';
import { NgxMatTimepickerModule } from 'ngx-mat-timepicker';
import { AuthGuard } from '../auth/AuthGuard';
import { SharedModule } from '../shared/shared.module';

const routes: Routes = [
  {path:'', component: AdminComponent,canActivate: [AuthGuard]},
  {path:'flight',component: FlightComponent,canActivate: [AuthGuard]},
  {path:'register/flight' ,component: RegisterFlightComponent,canActivate: [AuthGuard]},
  {path:'flight/schedule' ,component: FlightScheduleComponent,canActivate: [AuthGuard]}
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
    MatNativeDateModule,
    AngularMaterialModule,
    NgxMatTimepickerModule.setLocale('en-US'),
    ReactiveFormsModule,
    SharedModule
  ]
})
export class AdminModule { 
}
