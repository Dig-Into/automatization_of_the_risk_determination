import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './utils/guards/auth.guard';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  {
    path: 'home',
    loadChildren: () =>
      import('./home/feature/home.module').then((m) => m.HomePageModule),
      canActivate: [AuthGuard]
  },
  {
    path: 'login',
    loadChildren: () =>
      import('./login/feature/login.module').then((m) => m.LoginModule),
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
