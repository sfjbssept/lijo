import { HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpParams, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { exhaustMap, Observable, take } from "rxjs";
import { AuthService } from "./auth.service";
@Injectable()
export class AuthHttpInterceptor implements HttpInterceptor {
    intercept(req: HttpRequest<any>, next: HttpHandler) {
        let token = localStorage.getItem('token');
        if (!token) {
            return next.handle(req);
        }
        const modifiedReq = req.clone({ headers: new HttpHeaders().set('Authorization', token) });
        return next.handle(modifiedReq);
    }
}
