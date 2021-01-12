import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from '../models/login';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

login: Login = new Login();
message:String;

  constructor(private loginService: LoginService, private router:Router) { }

  ngOnInit() {
  }

  loginCheck(){
    console.log(this.login);
    this.loginService.login(this.login).subscribe(response => {
      alert(JSON.stringify(response));
      console.log(response);
      if(response.status== 'SUCCESS') {
        let adminId = response.userId;
        sessionStorage.setItem('adminId',String(adminId));

      }
      else
        this.message= response.message;
    })
  }

}
