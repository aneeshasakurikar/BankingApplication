import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TransactionDetails, UserAccountDetails } from '../models/models';

@Component({
  selector: 'app-account-details',
  templateUrl: './account-details.component.html',
  styleUrls: ['./account-details.component.css']
})
export class AccountDetailsComponent implements OnInit {
  accDetails = new UserAccountDetails();
  
  constructor(private http: HttpClient,private router:Router) { }

  ngOnInit(): void {
    //this.accDetails.userId = sessionStorage.getItem('userId');
    this.http.get<any>("http://localhost:8084/getAccountDetails/"+sessionStorage.getItem('userId')) 
    .subscribe(
      data => {
        this.accDetails = data
      }
      )
    
    
    }

    


}
