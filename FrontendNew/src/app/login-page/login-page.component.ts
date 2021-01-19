import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginCreds } from '../models/models';
import { HttpClient } from '@angular/common/http';
import { ServicesService } from '../services/services.service';
import { LocationStrategy } from '@angular/common';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  loginCreds: LoginCreds = new LoginCreds();
  message :string;

  constructor(private service: ServicesService,private router: Router, private location: LocationStrategy) {
    history.pushState(null, null, window.location.href);  
this.location.onPopState(() => {
  history.pushState(null, null, window.location.href);
});
   }

  login(){
    console.log(this.loginCreds);
    this.service.login(this.loginCreds).subscribe(response=>{
      //alert(JSON.stringify(response));
      if(response.status == 'SUCCESS'){
        let userId = response.userId;
        sessionStorage.setItem('userId', userId);
        this.router.navigate(['userDashboard']);
      }
      else{
        this.message = response.message;
      }
    })
  }
goHome():void{
  const navigationDetails: string[] = [''];
  this.router.navigate(navigationDetails);
}

  ngOnInit() {
  }

}
