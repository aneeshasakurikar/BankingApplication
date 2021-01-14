import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginCreds } from '../models/models';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  loginCreds: LoginCreds = new LoginCreds();

  constructor(private http: HttpClient,private router: Router) { }

// userDashboard():void{
//   const navigationDetails: string[] = ['/userDashboard'];
//     this.router.navigate(navigationDetails);
// }



  ngOnInit() {
  }

}
