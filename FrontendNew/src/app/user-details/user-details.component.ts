import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserDetails } from '../models/models';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

  constructor(private http: HttpClient,private router:Router) { }

  user = new UserDetails();

  ngOnInit(): void {
    this.http.get<any>("http://localhost:8084/viewDetails/"+10102) 
    .subscribe(
      data => {
        this.user = data
      }
      )}

}
