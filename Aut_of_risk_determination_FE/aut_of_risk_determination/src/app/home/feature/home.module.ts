import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ContainerBigComponent } from '../../shared/wrapper/wrapper-big.component'
import { FormsModule } from '@angular/forms';
import { HomePage } from './home.page';
import { MatTableModule } from '@angular/material/table'  

import { HomePageRoutingModule } from './home-routing.module';


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    HomePageRoutingModule,
    MatTableModule
    
  ],
  declarations: [HomePage, ContainerBigComponent]
})
export class HomePageModule {}