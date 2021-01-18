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
  creds: ChangePassword = new ChangePassword();
  constructor(private service: ServicesService, private router:Router) { }

  ngOnInit() {
  }
  changePassword() {
    this.service.changePassword(this.creds).subscribe(response => {
      
          alert(JSON.stringify(response.message));
          this.router.navigate(['login']);
        
      
      
    })
    
  }
}
