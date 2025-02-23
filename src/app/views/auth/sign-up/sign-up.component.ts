import { Component, inject } from '@angular/core';
import { Router, RouterLink } from '@angular/router'; // Add Router
import { FormsModule, ReactiveFormsModule, UntypedFormBuilder, Validators, type UntypedFormGroup } from '@angular/forms';
import { AuthService } from '../../../core/service/auth-service.service';

@Component({
  selector: 'app-sign-up',
  standalone: true,
  imports: [RouterLink, FormsModule, ReactiveFormsModule],
  templateUrl: './sign-up.component.html',
  styles: ``,
})
export class SignUpComponent {
  signupForm!: UntypedFormGroup;
  submitted: boolean = false;
  errorMessage: string = '';

  private fb = inject(UntypedFormBuilder);
  private authService = inject(AuthService);
  private router = inject(Router); // Inject Router

  constructor() {
    this.signupForm = this.fb.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required]],
    });
  }

  get form() {
    return this.signupForm.controls;
  }

  onSignUp() {
    this.submitted = true;
    this.errorMessage = '';

    if (this.signupForm.valid) {
      const { username, password } = this.signupForm.value;

      this.authService.register(username, password).subscribe({
        next: (response) => {
          console.log('Full response:', response);
          console.log('Status:', response.status);
          console.log('Body:', response.body);
          alert('Registration successful!');
          this.router.navigate(['/sign-in']);
        },
        error: (error) => {
          console.error('Registration error:', error);
          console.log('Status:', error.status); // Should show 403 if present
          console.log('Error body:', error.error); // Backend message
          this.errorMessage = error.status === 403
            ? 'Registration succeeded, but access was denied (403). Please log in.'
            : 'Registration failed: ' + (error.error || 'Unknown error');
          alert(this.errorMessage);
        },
      });
    }
  }
}