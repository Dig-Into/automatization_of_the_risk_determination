import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/login/data-access/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  isLoggedIn = false;

  constructor(private router: Router, private authService: AuthService) {}

  ngOnInit(): void {
    this.isLoggedIn = this.authService.getIsLoggedIn();
  }

  logOut(): void {
    this.authService.logout();
    this.isLoggedIn = false;
    this.router.navigate(['/login']);
  }

  goHome() {
    this.router.navigate(['/home']);
  }

  goToKreirajProcenu() {
    this.router.navigate(['/procena-rizika-kreiranje']);
  }

  goToPregledajProcenu() {
    this.router.navigate(['/procena-rizika-pregled']);
  }

  goToMere() {
    this.router.navigate(['/mere']);
  }

  goToMerePregled() {
    this.router.navigate(['/mere-pregled']);
  }

}