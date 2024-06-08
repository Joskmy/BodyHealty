import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthGoogleService } from '../auth-google.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  constructor (private authGoogleService: AuthGoogleService){

  }

  login(){
    this.authGoogleService.login();
  }

}
