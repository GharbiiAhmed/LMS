import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/lms/auth'; // Adjust the URL if needed

  constructor(private http: HttpClient) {}

  // Login method
  login(username: string, password: string): Observable<{ token: string; role: string }> {
    // Prepare the request body
    const body = new HttpParams()
      .set('username', username)
      .set('password', password);

    // Set headers for form data
    const headers = new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' });

    return this.http.post<{ token: string; role: string }>(
      `${this.apiUrl}/login`,
      body.toString(),
      { headers }
    );
  }

  // Register method
  register(username: string, password: string): Observable<any> {
    const body = new HttpParams()
      .set('username', username)
      .set('password', password);

    const headers = new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' });

    return this.http.post<any>(
      `${this.apiUrl}/register/learner`,
      body.toString(),
      { headers, observe: 'response', responseType: 'text' as 'json' } // Expect text response
    );
  }
  // Register method
  registertrainer(username: string, password: string): Observable<any> {
    const body = new HttpParams()
      .set('username', username)
      .set('password', password);

    const headers = new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' });

    return this.http.post<any>(
      `${this.apiUrl}/register/trainer`,
      body.toString(),
      { headers, observe: 'response', responseType: 'text' as 'json' } // Expect text response
    );
  }

  // Save the token to localStorage
  saveToken(token: string) {
    localStorage.setItem('token', token);
  }

  // Get the token from localStorage
  getToken(): string | null {
    return localStorage.getItem('token');
  }

  // Save the user's role to localStorage
  saveUserRole(role: string) {
    localStorage.setItem('role', role);
  }

  // Get the user's role from localStorage
  getUserRole(): string {
    return localStorage.getItem('role') || ''; // Default to empty string if no role found
  }

  // Save session (you can combine role and token if needed)
  setSession(token: string, role: string) {
    this.saveToken(token);
    this.saveUserRole(role);
  }

  // Get session data (token and role)
  get session(): string | null {
    return this.getToken();  // Or return a combination of token and role if needed
  }

  // Logout and remove token and role from localStorage
  logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('role');
  }
}
