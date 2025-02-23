// src/app/core/helpers/error.interceptor.ts
import { HttpRequest, HttpHandlerFn, HttpEvent } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { inject } from '@angular/core';
import { AuthService } from '../service/auth-service.service';

export function errorInterceptor(req: HttpRequest<any>, next: HttpHandlerFn): Observable<HttpEvent<any>> {
  const authenticationService = inject(AuthService);

  return next(req).pipe(
    catchError(err => {
      if (err.status === 401) {
        //authenticationService.removeSession();
        window.location.reload();
      }

      const error = err.error?.message || err.statusText;
      return throwError(() => error);
    })
  );
}