import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatNativeDateModule } from '@angular/material/core';
import { Routes, RouterModule } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { NgxMatTimepickerModule } from 'ngx-mat-timepicker';
import { AngularMaterialModule } from '../AngularMaterialModule';
import { PassengerComponent } from './passenger/passenger.component';

const routes: Routes = [
  {path:'passenger' ,component:PassengerComponent}
]

@NgModule({
  declarations: [
    PassengerComponent
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
export class UserModule { }
