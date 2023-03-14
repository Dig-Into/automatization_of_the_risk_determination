import { Component } from '@angular/core';
import { LoginService } from '../data-access/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string;
  password: string;

  constructor(private loginService: LoginService) {}

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

  onSubmit(): void {
    this.loginService.login(this.email, this.password)
      .subscribe(response => console.log(response),
      error => console.error(error)
    );
  }
}
