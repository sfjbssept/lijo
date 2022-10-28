import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatNativeDateModule} from '@angular/material/core'; 
import { HttpClientModule } from '@angular/common/http';
import { AngularMaterialModule } from '../AngularMaterialModule';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';


@NgModule({
  declarations: [],
  imports: [
  ],
  exports:[
    BrowserAnimationsModule,
    MatNativeDateModule,
    AngularMaterialModule,
  ]
})
export class SharedModule { }
