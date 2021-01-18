import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {
  userId
  constructor(private router: Router) { }

  ngOnInit() {
  }
  logout(){
    //this.userId = sessionStorage.getItem('userId');
    sessionStorage.removeItem('userId');
    this.router.navigate(['logout']);
  }
  

}
