import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HomePage } from './home.page';
import { MatTableModule } from '@angular/material/table'  
import { HomePageRoutingModule } from './home-routing.module';
import { SharedModule } from 'src/app/shared/shared.module'; 


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    HomePageRoutingModule,
    MatTableModule,
    SharedModule
    
  ],
  declarations: [HomePage]
})
export class HomePageModule {}