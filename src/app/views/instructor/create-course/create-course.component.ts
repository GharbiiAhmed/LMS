import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseService } from '@/app/services/course.service';
import { ContentService } from '@/app/services/content.service';
import { AppMenuComponent } from '@/app/components/app-menu/app-menu.components';
import { Footer3Component } from '@/app/components/footers/footer3/footer3.component';
import { StepperDirective } from '@/app/core/directive/stepper.directive';
import { CourseDetailComponent } from './components/course-detail/course-detail.component';
import { CourseMediaComponent } from './components/course-media/course-media.component';

@Component({
  selector: 'app-create-course',
  standalone: true,
  imports: [
    CommonModule, // Add this to enable ngClass, ngIf, etc.
    AppMenuComponent,
    CourseDetailComponent,
    CourseMediaComponent,
    Footer3Component,
    StepperDirective,
  ],
  templateUrl: './create-course.component.html'
})
export class CreateCourseComponent {
  courseId: number | null = null;
  courseData: any = {};
  mediaData: any = {};
  currentStep: number = 1;
  isSubmitting: boolean = false;

  constructor(
    private courseService: CourseService,
    private contentService: ContentService
  ) {}

  onCourseDetailsSubmitted(data: any) {
    this.courseData = data;
    this.nextStep();
  }

  onMediaSubmitted(data: any) {
    this.mediaData = data;
    this.submitAll();
  }

  nextStep() {
    this.currentStep++;
  }

  prevStep() {
    if (this.currentStep > 1) this.currentStep--;
  }

  submitAll() {
    this.isSubmitting = true;
    this.courseService.createCourse(this.courseData).subscribe({
      next: (response) => {
        this.courseId = response.id;
        console.log('Course created with ID:', this.courseId);
        if (this.mediaData && this.courseId) {
          this.contentService.addContent(this.courseId, this.mediaData).subscribe({
            next: (mediaResponse) => {
              console.log('Media added:', mediaResponse);
              this.isSubmitting = false;
              alert('Course and media successfully created!');
            },
            error: (error) => {
              console.error('Error adding media:', error);
              this.isSubmitting = false;
            },
          });
        } else {
          this.isSubmitting = false;
          alert('Course created, no media added.');
        }
      },
      error: (error) => {
        console.error('Error creating course:', error);
        this.isSubmitting = false;
      },
    });
  }
}
