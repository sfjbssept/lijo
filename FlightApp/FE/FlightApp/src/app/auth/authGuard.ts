import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Observable } from "rxjs";
import { AuthService } from "./auth.service";
@Injectable({
    providedIn: 'root'
})
export  class AuthGuard implements CanActivate{
    isAdmin: boolean =false;
    constructor(private authservice:AuthService, private router: Router) {
    }
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
        if(state.url.includes('admin')){
         this.isAdmin = true;
        }else{
         this.isAdmin =false;
        }

        if(!this.authservice.isLoggedIn()){
        return this.router.createUrlTree(['/login']);
        }else if(this.isAdmin && this.authservice.getRole() !== 'admin'){
        return this.router.createUrlTree(['/login']);
        }else{
            return true;
        }
    } 
}