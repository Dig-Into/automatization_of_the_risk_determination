import { Component } from '@angular/core';
import { AuthService } from './login/data-access/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'auth_of_risk_determination';


  constructor(private authService: AuthService) {}

  loggedIn = this.authService.isLoggedIn();


}
