import { Component, EventEmitter, Output, Input } from '@angular/core';
import { LightgalleryModule } from 'lightgallery/angular';
import lgVideo from 'lightgallery/plugins/video';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'course-media',
  standalone: true,
  imports: [LightgalleryModule, FormsModule],
  templateUrl: './course-media.component.html',
  styleUrl: './course-media.component.scss',
})
export class CourseMediaComponent {
  @Output() submit = new EventEmitter<any>();
  @Output() prev = new EventEmitter<void>(); // Add this for Previous button
  @Input() isSubmitting: boolean = false;

  media = {
    id: null as string | null,
    file_url: null as string | null,
    type: null as string | null,
    course_id: null as string | null,
    image: null as File | null,
    videoUrl: 'https://www.youtube.com/embed/tXHviS-4ygo',
    videoFile: null as File | null,
  };

  settings = {
    counter: false,
    plugins: [lgVideo],
    selector: 'a',
    download: false,
  };

  onImageSelected(event: Event) {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files[0]) {
      this.media.image = input.files[0];
      this.media.file_url = URL.createObjectURL(input.files[0]); // Handle image file URL
      this.media.type = 'image'; // Set the type to image
    }
  }

  onVideoFileSelected(event: Event) {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files[0]) {
      this.media.videoFile = input.files[0];
      this.media.file_url = URL.createObjectURL(input.files[0]); // Handle video file URL
      this.media.type = 'video'; // Set the type to video
    }
  }

  onSubmit() {
    // Map the form data to match the backend structure
    const payload = {
      id: this.media.id,
      file_url: this.media.file_url,
      type: this.media.type,
      course_id: this.media.course_id,
    };
    this.submit.emit(payload); // Emit the mapped data to parent
  }

  onPrev() {
    this.prev.emit(); // Emit event to parent
  }
}
