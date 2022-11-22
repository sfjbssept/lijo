import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatNativeDateModule } from '@angular/material/core';
import { Routes, RouterModule } from '@angular/router';
import { NgxMatTimepickerModule } from 'ngx-mat-timepicker';
import { AngularMaterialModule } from '../AngularMaterialModule';
import { PassengerComponent } from './passenger/passenger.component';
import { PassengerDataComponent } from './passenger-data/passenger-data.component';
import { AuthGuard } from '../auth/AuthGuard';
import { BookingHistoryComponent } from './booking-history/booking-history.component';
import { SharedModule } from '../shared/shared.module';
import { PnrSearchComponent } from '../pnr-search/pnr-search.component';

const routes: Routes = [
  {path:'passenger' ,component:PassengerComponent,canActivate: [AuthGuard]},
  {path:'passenger/data',component: PassengerDataComponent,canActivate: [AuthGuard]},
  {path:'booking/history',component: BookingHistoryComponent,canActivate: [AuthGuard]}
]

@NgModule({
  declarations: [
    PassengerComponent,
    PassengerDataComponent,
    BookingHistoryComponent
  ],
  imports: [
    FormsModule,
    CommonModule,
    RouterModule.forChild(routes),
   // FontAwesomeModule,
    MatNativeDateModule,
    AngularMaterialModule,
    NgxMatTimepickerModule.setLocale('en-US'),
    ReactiveFormsModule,
    SharedModule,
    PnrSearchComponent
  ]
})
export class UserModule { 
}
