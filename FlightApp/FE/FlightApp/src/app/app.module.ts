import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FlightSearchComponent } from './flight/flight-search/flight-search.component';
import { FlightComponent } from './flight/flight.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from './shared/shared.module';
import { TicketBookingComponent } from './ticket-booking/ticket-booking.component';
import { PnrSearchComponent } from './pnr-search/pnr-search.component';
import { AuthComponent } from './auth/auth.component';
import { AuthHttpInterceptor } from './auth/authHttpInterceptor';
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FlightSearchComponent,
    FlightComponent,
    TicketBookingComponent,
    PnrSearchComponent,
    AuthComponent,
    AuthComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    SharedModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthHttpInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent],
  //schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
