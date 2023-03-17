import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatDialogModule } from '@angular/material/dialog';
import { FormsModule } from '@angular/forms';
import { ProcenaRizikaComponent } from './procena-rizika.component';
import { ProcenaRoutingModule } from './procena-routing.module';
import { SharedModule } from 'src/app/shared/shared.module'; 

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ProcenaRoutingModule,
    SharedModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatDialogModule
  ],
  declarations: [ProcenaRizikaComponent],
})
export class ProcenaModule {}