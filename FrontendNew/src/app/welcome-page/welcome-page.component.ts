import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserDetails } from '../models/models';

@Component({
  selector: 'app-welcome-page',
  templateUrl: './welcome-page.component.html',
  styleUrls: ['./welcome-page.component.css']
})
export class WelcomePageComponent implements OnInit {

  user = new UserDetails();

  constructor(private http: HttpClient,private router:Router) { }

  ngOnInit(): void {
    this.http.get<any>("http://localhost:8084/getUserDetails/"+sessionStorage.getItem('userId')) //sessionStorage.getItem('userId')
    .subscribe(
      data => {
        this.user = data
      }
      )}
}
