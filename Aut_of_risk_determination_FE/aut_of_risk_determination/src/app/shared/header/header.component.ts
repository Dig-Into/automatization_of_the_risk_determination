import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent  {

  constructor(private router: Router) {}

  logOut() {
    this.router.navigate(['/login']);
  }

  goHome() {
    this.router.navigate(['/home']);
  }
}
