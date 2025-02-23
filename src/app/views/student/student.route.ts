import { Route } from '@angular/router'
import { DashboardComponent } from './dashboard/dashboard.component'
import { SubscriptionComponent } from './subscription/subscription.component'
import { CourseListComponent } from './course-list/course-list.component'
import { CourseResumeComponent } from './course-resume/course-resume.component'
import { QuizComponent } from './quiz/quiz.component'
import { PaymentInfoComponent } from './payment-info/payment-info.component'
import { BookmarkComponent } from './bookmark/bookmark.component'
import { SettingComponent } from '../shared/setting/setting.component'
import { DeleteAccountComponent } from '../shared/delete-account/delete-account.component'
import { EditProfileComponent } from '../shared/edit-profile/edit-profile.component'

export const STUDENT_ROUTES: Route[] = [
  {
    path: 'dashboard',
    component: DashboardComponent,
    data: { title: 'Student Dashboard' },
  },
  {
    path: 'subscription',
    component: SubscriptionComponent,
    data: { title: 'Subscription' },
  },
  {
    path: 'course-list',
    component: CourseListComponent,
    data: { title: 'Course List' },
  },
  {
    path: 'course-resume',
    component: CourseResumeComponent,
    data: { title: 'Course Resume' },
  },
  {
    path: 'quiz',
    component: QuizComponent,
    data: { title: 'Student Quiz' },
  },
  {
    path: 'payment-info',
    component: PaymentInfoComponent,
    data: { title: 'Payment Info' },
  },
  {
    path: 'bookmark',
    component: BookmarkComponent,
    data: { title: 'Wishlist' },
  },
  {
      path: 'edit-profile',
      component: EditProfileComponent,
      data: { title: 'Edit Profile' },
    },
    {
      path: 'setting',
      component: SettingComponent,
      data: { title: 'Setting' },
    },
    {
      path: 'delete-account',
      component: DeleteAccountComponent,
      data: { title: 'Delete Account' },
    },
]
