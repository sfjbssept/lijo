import { NgModule } from '@angular/core';
import { CommonModule, registerLocaleData } from '@angular/common';
import { RegisterFlightComponent } from './register-flight/register-flight.component';
import { Router, RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { FormsModule } from '@angular/forms';
import { FlightComponent } from './flight/flight.component';


const routes: Routes = [
  {path:'', component: AdminComponent},
  {path:'flight',component: FlightComponent},
  {path:'register/flight' ,component: RegisterFlightComponent}
]
@NgModule({
  declarations: [
    RegisterFlightComponent,
    AdminComponent,
    FlightComponent
  ],
  imports: [
    FormsModule,
    CommonModule,
    RouterModule.forChild(routes)
  ]
})
export class AdminModule { }
