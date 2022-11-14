import { Token } from '@angular/compiler';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './auth.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {

  errorMessage ="";
  successMessage ="";
  @ViewChild('form') form: any;
  constructor(private authService: AuthService,private route: Router) { }

  ngOnInit(): void {
  this.errorMessage = this.successMessage = '';
  }
  onSubmit() {
  this.errorMessage = this.successMessage = '';
  console.log(this.form.value);
  this.authService.login(this.form.value).subscribe({
    next:(data:any) => {
      this.setLocalStorage(data);
      this.route.navigate(['/flight']);
    },
    error:(e) => {
      console.log(e);
      this.errorMessage = e.error + " "+e.statusText;
    }
  });
  }
  setLocalStorage(data: any) {
    localStorage.setItem('token',data.token);
    localStorage.setItem('tokenData',JSON.stringify(data))
  }
}