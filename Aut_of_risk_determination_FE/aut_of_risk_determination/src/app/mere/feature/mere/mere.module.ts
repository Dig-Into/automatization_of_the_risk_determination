import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatTableModule } from '@angular/material/table'; 
import { SharedModule } from 'src/app/shared/shared.module';
import { MereComponent } from './mere.component';
import { MereRoutingModule } from './mere-routing.module';
import { SearchComponent } from 'src/app/shared/search/search.component';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        MatTableModule,
        SharedModule,
        MereRoutingModule
    ],
    declarations: [MereComponent]
})

export class MereModule {}