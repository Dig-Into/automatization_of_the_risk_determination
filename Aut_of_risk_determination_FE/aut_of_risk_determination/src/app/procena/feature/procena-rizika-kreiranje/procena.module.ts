import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatTableModule } from '@angular/material/table'; 
import { ProcenaRizikaComponent } from './procena-rizika.component';
import { ProcenaRoutingModule } from './procena-routing.module';
import { SharedModule } from 'src/app/shared/shared.module'; 

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ProcenaRoutingModule,
    MatTableModule,
    SharedModule
    
  ],
  declarations: [ProcenaRizikaComponent]
})

export class ProcenaModule {}