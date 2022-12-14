import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthComponent } from './auth/auth.component';
import { AuthGuard } from './auth/AuthGuard';
import { FlightComponent } from './flight/flight.component';
import { PnrSearchComponent } from './pnr-search/pnr-search.component';
import { TicketBookingComponent } from './ticket-booking/ticket-booking.component';

const routes: Routes = [
  {path: '' , redirectTo: 'flight' ,pathMatch: 'full'},
  {path: 'flight' , component: FlightComponent},
  {path:'booking',component: TicketBookingComponent,canActivate: [AuthGuard]},
  {path:'pnr/:pnr',component:PnrSearchComponent},
  {path:'login',component: AuthComponent},
  {path:'pnr',component:PnrSearchComponent},
  {path: 'admin' ,loadChildren:() => import('./admin/admin.module').then(m => m.AdminModule)},
  {path:'user',loadChildren:()=>import('./user/user.module').then(m=>m.UserModule)}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
