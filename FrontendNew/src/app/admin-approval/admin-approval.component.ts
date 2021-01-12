import { Component, OnInit } from '@angular/core';
import { ServicesService } from '../services/services.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-admin-approval',
  templateUrl: './admin-approval.component.html',
  styleUrls: ['./admin-approval.component.css']
})
export class AdminApprovalComponent implements OnInit {

  userList: Object[];
  public users;
  constructor(private http: HttpClient) { }

  approve(){

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
