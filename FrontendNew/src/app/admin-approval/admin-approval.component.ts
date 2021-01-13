import { Component, OnInit } from '@angular/core';
import { ServicesService } from '../services/services.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { LocationStrategy } from '@angular/common';

@Component({
  selector: 'app-admin-approval',
  templateUrl: './admin-approval.component.html',
  styleUrls: ['./admin-approval.component.css']
})
export class AdminApprovalComponent implements OnInit {

  userList: Object[];
  public users;
  constructor(private http: HttpClient,private router:Router, private location: LocationStrategy) { 

    history.pushState(null, null, window.location.href);  
this.location.onPopState(() => {
  history.pushState(null, null, window.location.href);
});
  }

  approve(){

  }

  adminLogout():void{
    const navigationDetails: string[] = ['/adminLogout'];
    this.router.navigate(navigationDetails);
  }

  ngOnInit() {
    this.http.get<any>('http://localhost:8084/viewAllUnapprovedUsers')
      .subscribe(data => 
        {
          console.log(data);
          this.users = data;
        })
  }

}
