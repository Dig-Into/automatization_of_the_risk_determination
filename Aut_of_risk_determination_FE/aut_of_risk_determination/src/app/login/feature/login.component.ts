import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../data-access/auth.service';
import { LoginService } from '../data-access/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string;
  password: string;
  rememberMe: boolean;

  constructor(private loginService: LoginService, private router: Router, private authService: AuthService) {}

  onFocus() {
    const input = event.target as HTMLInputElement;
    const label = input.nextElementSibling as HTMLLabelElement;
    label.style.transform = 'translateY(-100%)';
  }
  
  onBlur() {
    const input = event.target as HTMLInputElement;
    const label = input.nextElementSibling as HTMLLabelElement;
    if (!input.value) {
      label.style.transform = '';
    }
  }

  addToLocalStorage(item: Object) {
    localStorage.setItem('token', item.toString());
  }

  onSubmit(): void {
    this.loginService.login(this.email, this.password).subscribe(
      (response) => {
        this.authService.login();
        this.addToLocalStorage(response.jwt);  
        this.router.navigate(['/home']);
      },
      (error: HttpErrorResponse) => {
        error => console.error(error)
      }
    );
  }

  
}