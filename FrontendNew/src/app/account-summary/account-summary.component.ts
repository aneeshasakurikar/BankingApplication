import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TransactionDetails } from '../models/models';

@Component({
  selector: 'app-account-summary',
  templateUrl: './account-summary.component.html',
  styleUrls: ['./account-summary.component.css']
})
export class AccountSummaryComponent implements OnInit {

  transactionDetails;
  
  constructor(private http: HttpClient,private router:Router) { }

  ngOnInit():void {
      this.http.get<any>("http://localhost:8084/viewTransactionList/"+sessionStorage.getItem('userId'))
      .subscribe(data=>{
        console.log(data)
        this.transactionDetails = data;
      })
    
  }

}
