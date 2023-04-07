import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatTableModule } from '@angular/material/table'; 
import { ProcenaRizikaPregledComponent } from './procena-rizika-pregled.component';
import { ProcenaRizikaRoutingModule } from './procena-rizika-pregled-routing.module';
import { SharedModule } from 'src/app/shared/shared.module';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        ProcenaRizikaRoutingModule,
        MatTableModule,
        SharedModule
    ],
    declarations: [ProcenaRizikaPregledComponent]
})

export class ProcenaRizikaPregledModule {}