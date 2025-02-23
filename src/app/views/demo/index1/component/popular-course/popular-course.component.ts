import { Component } from '@angular/core'
import { courseList } from '../../data'
import { NgbNavModule, NgbRatingModule } from '@ng-bootstrap/ng-bootstrap'
import { CommonModule } from '@angular/common'
import { CourseService } from '../../../../../services/course.service';

@Component({
  selector: 'index1-popular-course',
  standalone: true,
  imports: [NgbNavModule, NgbRatingModule, CommonModule],
  templateUrl: './popular-course.component.html',
  styles: ``,
})
export class PopularCourseComponent {
  // courseList = courseList
    courses: any[] = [];
    selectedCourse: any;

    constructor(private courseService: CourseService) {}

    ngOnInit(): void {
      this.getCourses();
    }

    getCourses(): void {
      this.courseService.getCourses().subscribe((data) => {
        this.courses = data;
      });
      console.log(this.courses)
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