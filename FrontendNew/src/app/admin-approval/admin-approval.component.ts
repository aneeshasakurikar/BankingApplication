import { Component, OnInit } from '@angular/core';
import { ServicesService } from '../services/services.service';
import { HttpClient } from '@angular/common/http';
<<<<<<< HEAD
import { UserApprovalDetails } from '../models/models';
=======
import { Router } from '@angular/router';
import { LocationStrategy } from '@angular/common';
>>>>>>> 3645ace00adae235caba3f87c439fd0f4adb38cf

@Component({
  selector: 'app-admin-approval',
  templateUrl: './admin-approval.component.html',
  styleUrls: ['./admin-approval.component.css']
})
export class AdminApprovalComponent implements OnInit {

  userList: Object[];
  public users;
<<<<<<< HEAD
  public admin = new UserApprovalDetails();
  constructor(private http: HttpClient) { }
=======
  constructor(private http: HttpClient,private router:Router, private location: LocationStrategy) { 

    history.pushState(null, null, window.location.href);  
this.location.onPopState(() => {
  history.pushState(null, null, window.location.href);
});
  }
>>>>>>> 3645ace00adae235caba3f87c439fd0f4adb38cf

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

  sendAdminRemarks(index){
    this.admin.aadharNumber = index;    
    console.log(this.admin)
    this.http.post<any> ('http://localhost:8084/adminApproval', this.admin).subscribe(
      data => {console.log(data)
      if (data.status=="SUCCESS")
      {
        alert(data.message);
      }
    }
    )
    location.reload();
  } 
  

}
