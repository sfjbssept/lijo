import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FlightComponent } from './flight/flight.component';

const routes: Routes = [
  {path: '' , redirectTo: 'flight' ,pathMatch: 'full'},
  {path: 'flight' , component: FlightComponent},
  {path: 'admin' ,loadChildren:() => import('./admin/admin.module').then(m => m.AdminModule)},
  {path:'user',loadChildren:()=>import('./user/user.module').then(m=>m.UserModule)}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
