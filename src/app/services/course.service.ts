import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CourseService {
  private apiUrl = 'http://localhost:8080/lms/api/courses';

  constructor(private http: HttpClient) {}

  createCourse(course: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, course);
  }

  updateCourse(course: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${course.id}`, course);
  }

  getCourse(courseId: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${courseId}`);
  }

  deleteCourse(courseId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${courseId}`);
  }
}
