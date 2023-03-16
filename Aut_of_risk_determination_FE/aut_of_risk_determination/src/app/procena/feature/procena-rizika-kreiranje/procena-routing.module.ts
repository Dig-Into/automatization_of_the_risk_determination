import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProcenaRizikaComponent } from './procena-rizika.component';

const routes: Routes = [
  {
    path: '',
    component: ProcenaRizikaComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProcenaRoutingModule {}