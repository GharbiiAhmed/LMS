// src/app/core/helpers/fake-backend.ts
import { HttpRequest, HttpResponse, HttpHandlerFn } from '@angular/common/http';
import { Observable, of, throwError } from 'rxjs';

export function fakeBackendInterceptor(req: HttpRequest<any>, next: HttpHandlerFn): Observable<any> {
  const { url, method, body } = req;

  console.log('Fake backend intercepted:', url); // Add this to debug

  // Mock /login endpoint
  if (url.endsWith('/login') && method === 'POST') {
    const { username, password } = body;

    // Mock user credentials (replace with your test credentials)
    const mockUsers = [
      { username: 'test', password: 'test123', token: 'fake-jwt-token' }
    ];

    const user = mockUsers.find(u => u.username === username && u.password === password);
    if (user) {
      return of(new HttpResponse({ status: 200, body: { token: user.token } }));
    } else {
      return throwError(() => ({ status: 401, error: { message: 'Invalid credentials' } }));
    }
  }

  // Pass through other requests
  return next(req);
}