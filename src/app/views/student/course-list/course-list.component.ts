import { Component, OnInit } from '@angular/core';
import { NgbPaginationModule, NgbProgressbarModule } from '@ng-bootstrap/ng-bootstrap';
import { CourseService } from '../../../services/course.service';
import { SelectFormInputDirective } from '@/app/core/directive/select-form-input.directive';
import { CommonModule } from '@angular/common'; // Import CommonModule

import aos from 'aos';

interface Course {
  id: number;
  name: string;
  description: string;
  syllabus: string;
  user_id: number;
}

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [
    CommonModule, // Add this
    NgbPaginationModule,
    NgbProgressbarModule,
    SelectFormInputDirective,
  ],
  templateUrl: './course-list.component.html',
  styles: ``,
})
export class CourseListComponent implements OnInit {
  courseList: Course[] = [];

  constructor(private courseService: CourseService) {}

  ngOnInit(): void {
    const userId = 2; // Replace with the actual user ID
    this.courseService.getCoursesByUserId(userId).subscribe(
      (courses: Course[]) => {
        this.courseList = courses;
      },
      (error: any) => {
        console.error(error);
      }
    );
    
  }
}