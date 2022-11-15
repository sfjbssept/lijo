import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit, OnDestroy {

  isLoggedIn: Boolean = false;
  isAdmin: Boolean =false;
  constructor(private authService: AuthService,
    private route: Router) { }

  authSubjectSub: any;

  ngOnInit(): void {
    this.isLoggedIn = this.isAdmin =  false;
    this.authSubjectSub = this.authService.authSubject.subscribe({
      next: (data: any) => {
        this.isLoggedIn = data.isLoggedIn;
        this.isAdmin = (data.role==='admin');
      }
    })
  }
  ngOnDestroy(): void {
    if (this.authSubjectSub) {
      this.authSubjectSub.unsubscribe();
    }
  }
  logout() {
    localStorage.clear();
    this.authService.authSubject.next({'isLoggedIn':false,'role':''});
    this.route.navigate(['/login'])
  }
}
