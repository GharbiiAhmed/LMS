import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { QuillEditorComponent } from 'ngx-quill';
import { SelectFormInputDirective } from '@/app/core/directive/select-form-input.directive';

@Component({
  selector: 'course-detail',
  standalone: true,
  imports: [SelectFormInputDirective, QuillEditorComponent, FormsModule],
  templateUrl: './course-detail.component.html',
  styles: [],
})
export class CourseDetailComponent {
  @Output() submit = new EventEmitter<any>();

 // Define course as an empty object initially
 @Input() course: any = {};

  // Quill editor content (for course description)
  content: string = `<div class="bg-body border rounded-bottom h-400px overflow-hidden quilleditor">
    <br><h1>Quill Rich Text Editor</h1><br>
    <p>Quill is a free, open-source WYSIWYG editor built for the modern web...</p>
    <!-- Truncated for brevity, keep your full content here -->
  </div>`;

  onSubmit() {
    // Add description from the Quill editor to course
    this.course.description = this.content;
    this.submit.emit(this.course);
  }
}
