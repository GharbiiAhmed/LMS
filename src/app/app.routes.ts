
import { inject } from '@angular/core'
import {
  ActivatedRoute,
  RedirectCommand,
  Router,
  Routes,
  type RouterStateSnapshot,
  type UrlTree,
} from '@angular/router'
import { AuthService } from './core/service/auth-service.service'
import { AccountLayoutComponent } from './layouts/account-layout/account-layout.component'
import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component'
import { AuthLayoutComponent } from './layouts/auth-layout/auth-layout.component'
import { SettingComponent } from './views/shared/setting/setting.component'
import { DeleteAccountComponent } from './views/shared/delete-account/delete-account.component'
import { EditProfileComponent } from './views/shared/edit-profile/edit-profile.component'
// Helper function to check user roles
const canAccess = (allowedRoles: string[]) => {
  return (url: any) => {
    const router = inject(Router);
    const authService = inject(AuthService);
    const userRole = authService.getUserRole();

    if (!authService.session) {
      return router.createUrlTree(['/sign-in'], {
        queryParams: { returnUrl: url._routerState.url },
      });
    }

    if (!allowedRoles.includes(userRole)) {
      return router.createUrlTree(['/']); // Redirect unauthorized users to home
    }

    return true;
  };
};


export const routes: Routes = [
  {
    path: '',
    redirectTo: '/index-1',
    pathMatch: 'full',
  },
  {
    path: '',
    loadChildren: () =>
      import('./views/demo/demo.route').then((mod) => mod.DEMO_ROUTES),
  },
  {
    path: 'course',
    loadChildren: () =>
      import('./views/course/course.route').then((mod) => mod.COURSE_ROUTES),
  },
  {
    path: 'hero',
    loadChildren: () =>
      import('./views/hero/hero.route').then((mod) => mod.HERO_ROUTES),
  },
  {
    path: 'shop',
    loadChildren: () =>
      import('./views/shop/shop.route').then((mod) => mod.SHOP_ROUTES),
  },
  {
    path: 'help',
    loadChildren: () =>
      import('./views/help/help.route').then((mod) => mod.HELP_ROUTES),
  },
  {
    path: '',
    loadChildren: () =>
      import('./views/views.route').then((mod) => mod.VIEWS_ROUTES),
  },
  {
    path: 'instructor',
    component: AccountLayoutComponent,
    canActivate: [canAccess(['TRAINER', 'ADMIN'])],
    loadChildren: () =>
      import('./views/instructor/instructor.route').then(
        (mod) => mod.INSTRUCTOR_ROUTES
      ),
  },

  
    {
      path: 'student',
      component: AccountLayoutComponent,
      canActivate: [canAccess(['LEARNER', 'TRAINER', 'ADMIN'])],
      loadChildren: () =>
        import('./views/student/student.route').then((mod) => mod.STUDENT_ROUTES),
    },
  

    {
      path: 'admin',
      component: AdminLayoutComponent,
      canActivate: [canAccess(['ADMIN'])],
      loadChildren: () =>
        import('./views/admin/admin.route').then((mod) => mod.ADMIN_ROUTES),
    },
  
  {
    path: '',
    component: AuthLayoutComponent,
    loadChildren: () =>
      import('./views/auth/auth.route').then((mod) => mod.AUTH_ROUTES),
  },
  {
    path: 'edit-profile',
    canActivate: [canAccess(['LEARNER', 'TRAINER', 'ADMIN'])],
    component: EditProfileComponent,
    data: { title: 'Edit Profile' },
  },
  {
    path: 'setting',
    canActivate: [canAccess(['LEARNER', 'TRAINER', 'ADMIN'])],
    component: SettingComponent,
    data: { title: 'Setting' },
  },
  {
    path: 'delete-account',
    canActivate: [canAccess(['LEARNER', 'TRAINER', 'ADMIN'])],
    component: DeleteAccountComponent,
    data: { title: 'Delete Account' },
  },
];
