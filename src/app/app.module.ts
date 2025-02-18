import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'; // Ensure HttpClientModule is imported
import { AppComponent } from './app.component';
import { CourseComponent } from './course/course.component';
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    CourseComponent // Add CourseComponent to declarations
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule // Ensure HttpClientModule is imported
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
