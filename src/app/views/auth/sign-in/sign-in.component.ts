import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import {
  FormsModule,
  ReactiveFormsModule,
  UntypedFormBuilder,
  UntypedFormGroup,
  Validators,
} from '@angular/forms';
import { RouterLink } from '@angular/router';
import { Router } from '@angular/router';
import { AuthService } from '../../../core/service/auth-service.service';

@Component({
  selector: 'app-sign-in',
  standalone: true,
  imports: [RouterLink, FormsModule, ReactiveFormsModule, CommonModule],
  templateUrl: './sign-in.component.html',
  styles: ``,
})
export class SignInComponent {
  signinForm!: UntypedFormGroup;
  submitted: boolean = false;
  passwordType: boolean = true;

  private fb = inject(UntypedFormBuilder);
  private authService = inject(AuthService); // Inject AuthService
  private router = inject(Router);

  constructor() {
    this.signinForm = this.fb.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required]],
    });
  }

  get form() {
    return this.signinForm.controls;
  }

  onLogin() {
    this.submitted = true;
    if (this.signinForm.valid) {
      const formValues = this.signinForm.getRawValue();
      const username = formValues.username?.trim() || '';
      const password = formValues.password?.trim() || '';
  
      if (!username || !password) {
        alert('Please provide both username and password.');
        return;
      }
  
      // Use AuthService to login
      this.authService.login(username, password).subscribe({
        next: (response) => {
          console.log('Received response:', response);
  
          // Set session using AuthService
          this.authService.setSession(response.token, response.role);
  
          // Determine the redirect URL based on the role
          let redirectUrl = '';
          switch (response.role) {
            case 'ADMIN':
              redirectUrl = '/admin/dashboard';
              break;
            case 'TRAINER':
              redirectUrl = '/instructor/dashboard';
              break;
            case 'LEARNER':
              redirectUrl = '/student/dashboard';
              break;
            default:
              redirectUrl = '/dashboard'; // Default if role is not recognized
              break;
          }
  
          // If a returnUrl is provided in the query params, use it instead of the default
          const returnUrl = this.router.parseUrl(this.router.url).queryParams['returnUrl'] || redirectUrl;
          this.router.navigate([decodeURIComponent(returnUrl)]);  // Navigate to the decoded returnUrl
        },
        error: (error) => {
          console.error('Full error details:', error);
          const status = error.status || 'Unknown';
          const message = error.error?.message || error.message || 'Unknown error';
          console.log('Status:', status);
          console.log('Error message:', message);
          alert(`Login failed: ${message} (Status: ${status})`);
        }
      });
    } else {
      alert('Please fill in all required fields correctly.');
    }
  }
}  