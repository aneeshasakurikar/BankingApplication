import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ChangePassword } from '../models/models';
import { ServicesService } from '../services/services.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {
  userId
  constructor(private http: HttpClient, private router:Router) { }

  ngOnInit() {
  }
  sendOtp() {
    let url = "http://localhost:8084/register";
    return this.http.post(url, this.userId) ;
     
  }
}
