import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login.component'; 
import { MatTableModule } from '@angular/material/table'  

import { LoginRoutingModule } from './login-routing.module'; 


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    LoginRoutingModule,
    MatTableModule
    
  ],
  declarations: [LoginComponent]
})
export class LoginModule {}