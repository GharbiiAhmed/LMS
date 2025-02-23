import { CommonModule } from '@angular/common';
import { Component, inject, OnInit } from '@angular/core';
import { Router } from '@angular/router'; // Add Router for navigation
import { FormsModule, ReactiveFormsModule, UntypedFormBuilder, Validators, UntypedFormGroup } from '@angular/forms';
import { NgbNavModule } from '@ng-bootstrap/ng-bootstrap';
import { AuthService } from '../../../../../core/service/auth-service.service';

@Component({
  selector: 'become-tabs',
  standalone: true,
  imports: [NgbNavModule, FormsModule, ReactiveFormsModule, CommonModule],
  templateUrl: './tabs.component.html',
  styles: ``,
})
export class TabsComponent implements OnInit {
  contactForm!: UntypedFormGroup;
  submit: boolean = false;
  errorMessage: string = '';
  successMessage: string = '';

  private fb = inject(UntypedFormBuilder);
  private authService = inject(AuthService); // Inject AuthService
  private router = inject(Router); // Inject Router for navigation

  ngOnInit(): void {
    this.contactForm = this.fb.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.minLength(6)]],
    });
  }

  get form() {
    return this.contactForm.controls;
  }

  onSubmit() {
    this.submit = true;
    this.errorMessage = '';
    this.successMessage = '';

    if (this.contactForm.valid) {
      const { username, password } = this.contactForm.value;
      this.registerTrainer(username, password);
    } else {
      console.log('Form is not valid');
      this.errorMessage = 'Please fill out all required fields correctly.';
    }
  }

  private registerTrainer(username: string, password: string) {
    this.authService.registertrainer(username, password).subscribe({
      next: (response) => {
        console.log('Full response:', response);
        console.log('Status:', response.status);
        console.log('Body:', response.body);
        this.successMessage = 'Trainer registration successful! Redirecting to sign-in...';
        alert('Registration successful!');
        setTimeout(() => {
          this.router.navigate(['/sign-in']); // Navigate to sign-in page
        }, 1000); // Optional delay for UX
      },
      error: (error) => {
        console.error('Registration error:', error);
        console.log('Status:', error.status);
        console.log('Error body:', error.error);
        this.errorMessage = error.status === 403
          ? 'Registration succeeded, but access was denied (403). Please log in.'
          : 'Registration failed: ' + (error.error || 'Unknown error');
        alert(this.errorMessage);
      },
    });
  }
}