import { Component, OnInit } from '@angular/core';
import { CourseService } from '../services/course.service'; // Ensure path is correct

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {
  courses: any[] = [];
  selectedCourse: any;

  constructor(private courseService: CourseService) {}

  ngOnInit(): void {
    this.getCourses();
  }

  getCourses(): void {
    this.courseService.getCourses().subscribe({
      next: (data: any[]) => {
        console.log('Received courses:', data); // Check if data is received
        this.courses = data;
      },
      error: (error) => {
        console.error('Error fetching courses', error);
      }
    });
  }

  createCourse(course: any): void {
    this.courseService.createCourse(course).subscribe((newCourse: any) => {
      this.courses.push(newCourse);
    });
  }

  updateCourse(course: any): void {
    this.courseService.updateCourse(course).subscribe(() => {
      this.getCourses();
    });
  }

  deleteCourse(courseId: number): void {
    this.courseService.deleteCourse(courseId).subscribe(() => {
      this.getCourses();
    });
  }
}