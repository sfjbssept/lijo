import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatNativeDateModule } from '@angular/material/core';
import { Routes, RouterModule } from '@angular/router';
import { FaIconLibrary, FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { NgxMatTimepickerModule } from 'ngx-mat-timepicker';
import { AngularMaterialModule } from '../AngularMaterialModule';
import { PassengerComponent } from './passenger/passenger.component';
import { PassengerDataComponent } from './passenger-data/passenger-data.component';
import { faStackOverflow } from '@fortawesome/free-brands-svg-icons';
import { faCoffee, faFilm, faTrash, faPenToSquare } from '@fortawesome/free-solid-svg-icons';
import { AuthGuard } from '../auth/AuthGuard';

const routes: Routes = [
  {path:'passenger' ,component:PassengerComponent,canActivate: [AuthGuard]},
  {path:'passenger/data',component: PassengerDataComponent,canActivate: [AuthGuard]}
]

@NgModule({
  declarations: [
    PassengerComponent,
    PassengerDataComponent
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
export class UserModule { 
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
