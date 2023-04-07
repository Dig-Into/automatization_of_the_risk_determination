import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private isLoggedIn = false;

  constructor() { }

  login(): void {    
    this.isLoggedIn = true;
    localStorage.setItem('isLoggedIn', 'true');
  }

  logout(): void {
    this.isLoggedIn = false;
    localStorage.setItem('isLoggedIn', 'false');
    localStorage.removeItem('token');
  }

  getIsLoggedIn(): boolean {
    return JSON.parse(localStorage.getItem('isLoggedIn') || 'false');
  }
  
}