import { Component, OnInit } from '@angular/core';
import { CourseService } from '../services/course.service'; // adjust path if needed

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
    this.courseService.getCourse(1).subscribe((data) => { // replace '1' with actual course id or method
      this.courses = data;
    });
  }

  createCourse(course: any): void {
    this.courseService.createCourse(course).subscribe((newCourse) => {
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

