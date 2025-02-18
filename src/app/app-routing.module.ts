import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CourseComponent } from './course/course.component';  // Example import

const routes: Routes = [
  { path: 'course', component: CourseComponent },  // Example route
  { path: '', redirectTo: '/course', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
