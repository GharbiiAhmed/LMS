import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CourseService {
  private apiUrl = 'http://localhost:8080/lms/api/courses'; // Update with your actual API URL

  constructor(private http: HttpClient) {}

  // Function to get Authorization header with token
  private getAuthHeaders(): HttpHeaders {
    const token = localStorage.getItem('token'); // Assuming the token is stored in localStorage under the key 'token'
    return new HttpHeaders({
      'Authorization': `Bearer ${token}`, // Attach token to the Authorization header
    });
  }

  // Create a new course
  createCourse(course: any): Observable<any> {
    const headers = this.getAuthHeaders();
    return this.http.post<any>(this.apiUrl, course, { headers });
  }
  

  // Update an existing course
  updateCourse(course: any): Observable<any> {
    const headers = this.getAuthHeaders();
    return this.http.put<any>(`${this.apiUrl}/${course.id}`, course, { headers });
  }

  // Get all courses
  getCourses(): Observable<any[]> {
    const headers = this.getAuthHeaders();
    return this.http.get<any[]>(this.apiUrl, { headers });
  }

  // Get courses by user ID
  getCoursesByUserId(userId: number): Observable<any[]> {
    const headers = this.getAuthHeaders();
    return this.http.get<any[]>(`${this.apiUrl}/user/${userId}`, { headers });
  }
  

  // Delete a course by its ID
  deleteCourse(courseId: number): Observable<void> {
    const headers = this.getAuthHeaders();
    return this.http.delete<void>(`${this.apiUrl}/${courseId}`, { headers });
  }
}
