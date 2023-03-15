import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  public isLoggedIn(): boolean {
    const token = localStorage.getItem('token');
    return token !== null;
  }
  
}
