import { Component, OnInit } from '@angular/core';
import { ServicesService } from '../services/services.service';
import { HttpClient } from '@angular/common/http';
import { UserApprovalDetails } from '../models/models';

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

  public admin = new UserApprovalDetails();
  
  constructor(private http: HttpClient,private router:Router, private location: LocationStrategy) { 

    history.pushState(null, null, window.location.href);  
this.location.onPopState(() => {
  history.pushState(null, null, window.location.href);
});
  }


  adminLogout():void{
    this.router.navigate(['']);
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
