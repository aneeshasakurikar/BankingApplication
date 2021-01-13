import { LocationStrategy } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminLoginComponent } from '../admin-login/admin-login.component';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(private router:Router, private location: LocationStrategy) { 
    history.pushState(null, null, window.location.href);  
this.location.onPopState(() => {
  history.pushState(null, null, window.location.href);
});
  }

  ngOnInit() {
  }

  openAdmin():void{
    const navigationDetails: string[] = ['/adminLogin'];
     this.router.navigate(navigationDetails);
  }

  register():void{
    const navigationDetails: string[] = ['/register'];
     this.router.navigate(navigationDetails);
  }

  checkStatus():void {
    const navigationDetails: string[] = ['/checkStatus'];
     this.router.navigate(navigationDetails);
  }

  userLogin():void{
    const navigationDetails: string[] = ['/userLogin'];
    this.router.navigate(navigationDetails);
  }

  netBanking():void{
    const navigationDetails: string[] = ['/netBankRegister'];
    this.router.navigate(navigationDetails);
  }

}
