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
  {
    path: 'procena-rizika-kreiranje',
    loadChildren: () =>
      import('./procena/feature/procena-rizika-kreiranje/procena.module').then((m) => m.ProcenaModule),
  },
  {
    path: 'procena-rizika-pregled',
    loadChildren: () =>
      import('./procena/feature/procena-rizika-pregled/procena-rizika-pregled.module').then((m) => m.ProcenaRizikaPregledModule),
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
