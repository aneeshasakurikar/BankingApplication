import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {  NewPassword } from '../models/models';
import { ServicesService } from '../services/services.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {

  constructor(private service: ServicesService, private router:Router) { }
  credentials: NewPassword = new NewPassword();
  ngOnInit() {
  }
  setNewPassword() {
    this.credentials.userId = sessionStorage.getItem('userId');
    this.service.setNewPassword(this.credentials).subscribe(response => {
      
          alert(JSON.stringify(response.message));
          location.reload();
        }
      
      
    )

}
}
