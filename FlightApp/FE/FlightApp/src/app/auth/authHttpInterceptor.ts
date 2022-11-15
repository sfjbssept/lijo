import { HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpParams, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { exhaustMap, Observable, take } from "rxjs";
import { AuthService } from "./auth.service";
@Injectable()
export class AuthHttpInterceptor implements HttpInterceptor{
    constructor(private authservice:AuthService) {

    }
    intercept(req: HttpRequest<any>, next: HttpHandler) {
     return  this.authservice.tokenDataSubject.pipe(take(1),
     exhaustMap(data => {
        if (!data) {
            return next.handle(req);
        }
        const modifiedReq = req.clone({headers: new HttpHeaders().set('Authorization', data.token)});
        return next.handle(modifiedReq);
    }));
    }

}